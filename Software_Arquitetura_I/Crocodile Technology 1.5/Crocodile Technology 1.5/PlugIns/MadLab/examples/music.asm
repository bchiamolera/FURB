;**************************************************************************
; FILE:      music.asm                                                    *
; CONTENTS:  'Mad Music Machine'		                                  *
; COPYRIGHT: MadLab Ltd. 2000		                                       *
; AUTHOR:    James Hutchby                                                *
; UPDATED:   10/09/00                                                     *
;**************************************************************************

	list p=16F84

	include "p16f84.inc"

	__config _XT_OSC & _WDT_ON & _PWRTE_ON & _CP_OFF

	errorlevel -207,-302, -305,-306


;**************************************************************************
;                                                                         *
; Specification                                                           *
;                                                                         *
;**************************************************************************

; 4 pushbuttons play 4 tunes


;**************************************************************************
;                                                                         *
; Port assignments                                                        *
;                                                                         *
;**************************************************************************

PORTA_IO		equ  b'10000'       	; port A I/O status
PORTB_IO 		equ  b'10000000'    	; port B I/O status

PORTA_INIT	equ	b'01100'
PORTB_INIT	equ	b'00000000'

POLL_IO		equ	b'01001111'

SPK			equ	4				; piezo speaker

#define		LED	PORTA,1        	; LED indicator


;**************************************************************************
;                                                                         *
; Constants and timings                                                   *
;                                                                         *
;**************************************************************************

CLOCK     	equ  d'4000000'   	; processor clock frequency in Hz

PRESCALE       equ  b'00000001'    ; prescale RTCC 1:4, weak pull-ups enabled

POLL_PERIOD    equ  b'00001111'    ; poll task despatch mask (~32 ms)

TUNE_PERIOD0   equ  b'01111111'    ; tune task despatch mask (~256 ms)
TUNE_PERIOD1   equ  b'00111111'    ; tune task despatch mask (~128 ms)

TUNE_BASE      equ  2              ; tune base octave
DEF_OCTAVE     equ  2              ; default octave (middle C)

C1_PERIOD      equ  d'511'  		; ~130.8 Hz
C1S_PERIOD     equ  d'482'         ; ~138.6 Hz
D1_PERIOD      equ  d'455'         ; ~146.9 Hz
D1S_PERIOD     equ  d'430'         ; ~155.6 Hz
E1_PERIOD      equ  d'406'         ; ~164.8 Hz
F1_PERIOD      equ  d'383'         ; ~174.6 Hz
F1S_PERIOD     equ  d'361'         ; ~185.0 Hz
G1_PERIOD      equ  d'341'         ; ~196.0 Hz
G1S_PERIOD     equ  d'322'         ; ~207.7 Hz
A1_PERIOD      equ  d'304'         ; ~220.0 Hz
A1S_PERIOD     equ  d'287'         ; ~233.1 Hz
B1_PERIOD      equ  d'271'         ; ~247.0 Hz
C2_PERIOD      equ  d'256'         ; ~261.6 Hz
C2S_PERIOD     equ  d'242'         ; ~277.2 Hz
D2_PERIOD      equ  d'228'         ; ~293.7 Hz


;**************************************************************************
;                                                                         *
; File register usage                                                     *
;                                                                         *
;**************************************************************************

RAM	set	h'0c'
MAX	set	h'50'

	cblock RAM

	flags          		; various flags
	clock:2				; system clock
	button				; button pressed
	spk_time:2	    		; speaker task despatch time
	spk_period:2  			; speaker task despatch period
	cur_octave          	; current octave, 1 to 4
	tune_note      		; tune note
	tune_pnt            	; tune pointer
	tune_ret            	; tune return
	work		      		; work register

	RAM_
	endc

	if RAM_ > MAX
	error "File register usage overflow"
	endif

; flags
SPK_ENABLE     equ  0         ; set if speaker enabled
SPK_TOGGLE	equ	1		; set if speaker on
POLL_TASK      equ  2         ; set if poll task already despatched
WAIT_RELEASE   equ  3         ; set if waiting for release
TUNE_ENABLE    equ  4         ; set if tune enabled
TUNE_TASK      equ  5         ; set if tune task already despatched
TEMPO_FAST     equ  6         ; set if tempo fast


;**************************************************************************
;                                                                         *
; Macros                                                                  *
;                                                                         *
;**************************************************************************

routine   macro label              ; routine
label
		endm

table     macro label              ; define lookup table
label     addwf PCL
		endm

entry     macro value              ; define table entry
		retlw value
		endm

index     macro label              ; index lookup table
		call label
		endm

jump      macro label              ; jump through table
		goto label
		endm

tstw      macro                    ; test w register
		iorlw 0
		endm

movff     macro f1,f2              ; move file to file
		movfw f1
		movwf f2
		endm

movlf     macro n,f                ; move literal to file
		movlw n
		movwf f
		endm

tris_A    macro                    ; tristate port A
		bsf STATUS,RP0
		movwf TRISA&h'7f'
		bcf STATUS,RP0
		endm

tris_B    macro                    ; tristate port B
		bsf STATUS,RP0
		movwf TRISB&h'7f'
		bcf STATUS,RP0
		endm

option_   macro                    ; set options
		bsf STATUS,RP0
		movwf OPTION_REG&h'7f'
		bcf STATUS,RP0
		endm


;--------------------------------------------------------------------------
; reset vector
;--------------------------------------------------------------------------

		org 0

		goto main_entry


lookup    movwf PCL                     ; look up table


;**************************************************************************
;                                                                         *
; Lookup tables                                                           *
;                                                                         *
;**************************************************************************

;--------------------------------------------------------------------------
; Tune definitions
;--------------------------------------------------------------------------

; rrttnnnn = note:
;       rr = rest duration (00 = none ... 11 = max)
;       tt = tone duration (00 = min ... 11 = max)
;     nnnn = tone value (0001 = C ... 1111 = D')
; xxxx0000 = escape:
; xx000000 = end of tune or sub-tune
; xx010000 = play sub-tune (followed by address)
; rr100000 = long rest (00 = min ... 11 = max)
; oo110000 = octave shift (00 = -2, 01 = -1, 10 = +1, 11 = +2)

C1        equ  b'0001'
C1S       equ  b'0010'
D1        equ  b'0011'
D1S       equ  b'0100'
E1        equ  b'0101'
F1        equ  b'0110'
F1S       equ  b'0111'
G1        equ  b'1000'
G1S       equ  b'1001'
A1        equ  b'1010'
A1S       equ  b'1011'
B1        equ  b'1100'
C2        equ  b'1101'
C2S       equ  b'1110'
D2        equ  b'1111'

start     macro label                   ; start of tune or sub-tune
label
		endm

tempo     macro t                       ; tempo
		entry t<<TEMPO_FAST
		endm

note      macro n,t,r                   ; note
		entry (r<<6)+((t-1)<<4)+n
		endm

stop      macro                         ; end of tune or sub-tune
		entry b'000000'
		endm

tune      macro address                 ; play sub-tune
		entry b'010000'
		entry address
		endm

rest      macro r                       ; long rest
		entry ((r-1)<<6)+b'100000'
		endm

octave    macro o                       ; octave shift
		if o==-2
		entry (b'00'<<6)+b'110000'
		endif
		if o==-1
		entry (b'01'<<6)+b'110000'
		endif
		if o==+1
		entry (b'10'<<6)+b'110000'
		endif
		if o==+2
		entry (b'11'<<6)+b'110000'
		endif
		endm


tune1
	     include "matilda.tun"     	; Waltzing Matilda
tune2
	     include "bluepetr.tun"     	; Blue Peter
tune3
	     include "thebrave.tun"     	; Scotland The Brave
tune4
     	include "flower.tun"     	; Flower O' Scotland


		table tune_table              ; tune table

		entry tune1
		entry tune2
		entry tune3
          entry tune4


		table tune_period             ; tune note period table

		entry 0
		entry C1_PERIOD>>1
		entry C1S_PERIOD>>1
		entry D1_PERIOD>>1
		entry D1S_PERIOD>>1
		entry E1_PERIOD>>1
		entry F1_PERIOD>>1
		entry F1S_PERIOD>>1
		entry G1_PERIOD>>1
		entry G1S_PERIOD>>1
		entry A1_PERIOD>>1
		entry A1S_PERIOD>>1
		entry B1_PERIOD>>1
		entry C2_PERIOD>>1
		entry C2S_PERIOD>>1
		entry D2_PERIOD>>1


          table tune_esc                ; tune task escape table

		goto tesc00                   ; end of tune or sub-tune
		goto tesc01                   ; play sub-tune
		goto tesc10                   ; long rest
		goto tesc11                   ; octave shift


;**************************************************************************
;                                                                         *
; Procedures                                                              *
;                                                                         *
;**************************************************************************

;--------------------------------------------------------------------------
; updates the system clock
;--------------------------------------------------------------------------

		routine clock_task

		rlf TMR0,w                    ; increment high byte if
		btfss clock+1,7              	; low byte rolled over
		goto ctask1
		skpc
		incf clock+0
ctask1    movwf clock+1
		rrf clock+1

		return


;--------------------------------------------------------------------------
; plays a note
;--------------------------------------------------------------------------

		routine play_note

		movff cur_octave,work     	; adjust for octave
		goto playn2
playn1    clrc
		rrf spk_period+0
		rrf spk_period+1
playn2    decfsz work
		goto playn1

		call clock_task               ; initialise task despatch time
		movff clock+0,spk_time+0
		movff clock+1,spk_time+1

		bsf flags,SPK_ENABLE          ; enable the speaker

		bcf flags,SPK_TOGGLE

		movlw PORTA_IO
		tris_A

		return


;--------------------------------------------------------------------------
; speaker task
;--------------------------------------------------------------------------

		routine spk_task

		btfsc flags,SPK_ENABLE        ; speaker enabled ?
		goto stask1
		movlw PORTA_IO				; speaker off if not
		tris_A
		goto sexit

stask1    call clock_task

		movfw clock+0               	; task to be despatched ?
		subwf spk_time+0,w
		movwf work
		movfw clock+1
		subwf spk_time+1,w
		skpc
		decf work

		btfsc work,7
		goto stask3
		tstf work
		bnz sexit
		andlw -h'40'
		bnz sexit                     ; branch if not

		clrwdt

stask2    movfw TMR0                    ; wait for task despatch time
		subwf spk_time+1,w
		andlw h'80'
		bz stask2

stask3    movlw 1<<SPK_TOGGLE          	; toggle speaker output
		xorwf flags

		movlw PORTA_IO
		btfsc flags,SPK_TOGGLE
		movlw PORTA_IO&~(1<<SPK)
		tris_A

		bcf PORTA,SPK

		movfw spk_period+1         	; next despatch time
		addwf spk_time+1
		skpnc
		incf spk_time+0
		movfw spk_period+0
		addwf spk_time+0

sexit     goto clock_task


;--------------------------------------------------------------------------
; main entry point
;--------------------------------------------------------------------------

		routine main_entry

		movlf PORTA_INIT,PORTA		; initialise ports
		movlw PORTA_IO
		tris_A
		movlf PORTB_INIT,PORTB
		movlw PORTB_IO
		tris_B

		clrwdt                        ; clear watchdog timer

		movlf RAM,FSR				; clear all registers
main1	clrf 0
		incf FSR
		movlw MAX
		subwf FSR,w
		bnz main1

		clrf TMR0

		clrf INTCON				; disable interrupts


;--------------------------------------------------------------------------
; 'round robin' task despatcher
;--------------------------------------------------------------------------

		routine main_loop

		clrwdt                        ; clear watchdog timer

		movlw PRESCALE                ; prescale RTCC
		option_


		call spk_task


;--------------------------------------------------------------------------
; polls the pushbuttons
;--------------------------------------------------------------------------

		routine poll_task

		movfw clock+0                	; task to be despatched ?
		andlw POLL_PERIOD
		skpz
		bcf flags,POLL_TASK
		skpnz
		btfsc flags,POLL_TASK
		goto pexit                    ; exit if not
		bsf flags,POLL_TASK

		movlw POLL_IO				; input mode
		tris_B

		movwf PORTB				; poll pushbuttons
		nop
		comf PORTB,w
		andlw h'0f'
		movwf work

		movlf PORTB_INIT,PORTB
		movlw PORTB_IO
		tris_B

		btfss flags,WAIT_RELEASE      ; waiting for release ?
		goto ptask1                   ; branch if not

		skpnz			        	; wait for button to be released
		bcf flags,WAIT_RELEASE
		goto pexit

ptask1	tstf work		               ; button pressed ?
		bz pexit                      ; branch if not

		clrf button               	; determine which button pressed
ptask2    incf button
		rrf work
		bnc ptask2

		decf button,w               	; play tune
		index tune_table
		movwf tune_pnt

		call lookup                   ; get the tempo
		incf tune_pnt
		bcf flags,TEMPO_FAST
		iorwf flags

		movlf DEF_OCTAVE,cur_octave	; initial octave

		clrf tune_note
		clrf tune_ret

		bsf flags,TUNE_ENABLE         ; enable the tune

		bcf LED        			; LED off

		bsf flags,WAIT_RELEASE        ; signal waiting for release

		bcf flags,SPK_ENABLE          ; disable the speaker

pexit     call clock_task


		call spk_task


;--------------------------------------------------------------------------
; tune task
;--------------------------------------------------------------------------

		routine tune_task

		btfss flags,TUNE_ENABLE       ; tune enabled ?
		goto texit                    ; exit if not

		movfw clock+0                 ; task to be despatched ?
		andlw TUNE_PERIOD0
		btfsc flags,TEMPO_FAST
		andlw TUNE_PERIOD1
		skpz
		bcf flags,TUNE_TASK
		skpnz
		btfsc flags,TUNE_TASK
		goto texit                    ; exit if not
		bsf flags,TUNE_TASK

		bcf LED       				; LED off

		movfw tune_note               ; note currently playing ?
		bz ttask2                     ; branch if not

		andlw b'1111'                 ; end of tone ?
		bz ttask1                     ; branch if yes

		decf tune_note                ; decrement duration

		goto texit

ttask1    swapf tune_note               ; start of rest
		tstf tune_note
		skpz
		decf tune_note

		bcf flags,SPK_ENABLE          ; disable the speaker

		goto texit

ttask2    movfw tune_pnt                ; get the next note in the
		call lookup                   ; tune
		movwf tune_note
		incf tune_pnt

		andlw b'1111'                 ; escape ?
		bz ttask3                     ; branch if yes

		clrf spk_period+0            	; play the tune note
		index tune_period
		movwf spk_period+1
		addwf spk_period+1
		rlf spk_period+0
		call play_note

		swapf tune_note               ; xxxxrrtt
		movfw tune_note
		andlw b'00000011'             ; 000000tt
		rlf tune_note                 ; xxxrrttx
		rlf tune_note                 ; xxrrttxx
		xorwf tune_note,w             ; xxrrtt__
		andlw b'11001111'             ; xx00tt__
		xorwf tune_note               ; 00rr00tt

		bsf LED        			; LED on

		goto texit

ttask3    swapf tune_note               ; interpret the escape code
		movfw tune_note
		rrf tune_note
		rrf tune_note
		andlw b'11'
		jump tune_esc

tesc00    movff tune_ret,tune_pnt 		; get the return address
		clrf tune_ret

		tstf tune_pnt                 ; end of tune ?
		bnz tloop                     ; branch if not

		bcf flags,TUNE_ENABLE         ; disable the tune
		bcf flags,SPK_ENABLE          ; disable the speaker

		goto texit

tesc01    movfw tune_pnt                ; save the return address
		movwf tune_ret
		incf tune_ret

		call lookup                   ; get the sub-tune address
		movwf tune_pnt

		goto tloop

tesc10    movlw b'11'                   ; get the rest duration
		andwf tune_note
		incf tune_note                ; 1,2,3,4

		bcf flags,SPK_ENABLE          ; disable the speaker

		goto texit

tesc11    movlw b'11'                   ; determine the new octave
		andwf tune_note
		btfss tune_note,1
		decf tune_note
		decf tune_note,w              ; -2,-1,+1,+2
		addwf cur_octave

tloop     clrf tune_note

		bcf flags,TUNE_TASK           ; despatch task again

texit     call clock_task


		goto main_loop                ; loop


		end

