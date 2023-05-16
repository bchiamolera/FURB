;**************************************************************************
; FILE:      stub.asm                                                     *
; CONTENTS:  Tester board stub and library                                *
; COPYRIGHT: MadLab Ltd. 2000                                             *
; AUTHOR:    James Hutchby                                                *
; UPDATED:   23/09/00                                                     *
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

;  _end_prog
;  _beep
;  _wait			w <= milliseconds (0 to 255)
;  _long_wait		_arg:w <= milliseconds (0 to 65535)
;  _mult8			w => _arg * w
;  _div8			w => _arg / w
;  _mult16		_arg1 => _arg1 * _arg2
;  _div16			_arg1 => _arg1 / _arg2


;**************************************************************************
;                                                                         *
; Port assignments                                                        *
;                                                                         *
;**************************************************************************

PORTA_IO		equ  b'10000'       	; port A I/O status
PORTB_IO 		equ  b'10000000'    	; port B I/O status

PORTA_INIT	equ	b'01100'
PORTB_INIT	equ	b'01000000'

POLL_IO		equ	b'11001111'

PIEZO		equ	4				; piezo speaker

IR			equ	6				; light sensor
MIC			equ	7				; sound sensor

#define	ENABLE_HI		dataA,2		; enable high 7-segment
#define	ENABLE_LO		dataA,3		; enable low 7-segment
#define	ENABLE_LEDS	dataB,6		; enable LEDs

LEDS_A	equ	b'00011'
LEDS_B	equ	b'00111111'

BUTTONS	equ	b'00001111'


;**************************************************************************
;                                                                         *
; Constants and timings                                                   *
;                                                                         *
;**************************************************************************

CLOCK     	equ  d'4000000'	; processor clock frequency in Hz

PRESCALE 		equ  b'00001000' 	; no prescale TMR0, weak pull-ups enabled

ISR_FREQ		equ	d'8000'		; isr frequency in Hz
MUX_FREQ		equ	d'500'		; multiplex frequency in Hz
POLL_FREQ		equ	d'50'		; poll frequency in Hz

BUZZER_PITCH	equ  d'2'			; buzzer pitch (half-period in isr's)


;**************************************************************************
;                                                                         *
; File register usage                                                     *
;                                                                         *
;**************************************************************************

RAM	set	h'0c'
MAX	set	h'50'

	cblock RAM

	context:2				; saved context
	buzzer				; buzzer period
	poll_cnt				; poll count
	mux_cnt				; multiplex count
	temp, dataA, dataB		; isr registers

	_io	               	; I/O flags
	_multiplex    			; multiplex (0 = high 7-seg, 1 = low 7-seg, 2 = LEDs)
	_leds				; LEDs
	_7segs		   		; 7-segments
	_timer				; wait timer

	_work1, _work2, _work3	; scratch registers
	_arg, _arg1:2, _arg2:2	; arithmetic routine arguments

	_reg_user:0			; user registers

	RAM_
	endc

	if RAM_ > MAX
	error "File register usage overflow"
	endif

; I/O flags
_BUTTON1		equ	3		; set if button #1 pressed
_BUTTON2		equ	2		; set if button #2 pressed
_BUTTON3		equ	1		; set if button #3 pressed
_BUTTON4		equ	0		; set if button #4 pressed
_BUZZER		equ	4		; set if buzzer on
_SPEAKER		equ	5		; set if speaker on
_LIGHT		equ	6		; set if light sensed
_SOUND		equ	7		; set if sound sensed

; multiplex flags
HI_7SEG		equ	7		; set if high 7-segment on
LO_7SEG		equ	6		; set if low 7-segment on


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

		goto _main_entry


lookup    movwf PCL                     ; look up table


;--------------------------------------------------------------------------
; interrupt vector
;--------------------------------------------------------------------------

		org 4

		goto isr


;**************************************************************************
;                                                                         *
; Lookup tables                                                           *
;                                                                         *
;**************************************************************************

		table bcd_hi					; 7-segment high digit

; A = 5, B = 4, C = 2, D = 1, E = 0, F = 7, G = 6, DP = 3

		entry b'10110111'        		; ABCDEF. = '0'
		entry b'00010100'        		; .BC.... = '1'
		entry b'01110011'        		; AB.DE.G = '2'
		entry b'01110110'        		; ABCD..G = '3'
		entry b'11010100'        		; .BC..FG = '4'
		entry b'11100110'        		; A.CD.FG = '5'
		entry b'11100111'        		; A.CDEFG = '6'
		entry b'00110100'        		; ABC.... = '7'
		entry b'11110111'        		; ABCDEFG = '8'
		entry b'11110110'        		; ABCD.FG = '9'

		entry b'11110101'        		; ABC.EFG = 'A'
		entry b'11000111'        		; ..CDEFG = 'b'
		entry b'10100011'        		; A..DEF. = 'C'
		entry b'01010111'        		; .BCDE.G = 'd'
		entry b'11100011'        		; A..DEFG = 'E'
		entry b'11100001'        		; A...EFG = 'F'


		table bcd_lo					; 7-segment low digit

; A = 6, B = 7, C = 1, D = 3, E = 4, F = 5, G = 2, DP = 0

		entry b'11111010'        		; ABCDEF. = '0'
		entry b'10000010'        		; .BC.... = '1'
		entry b'11011100'        		; AB.DE.G = '2'
		entry b'11001110'        		; ABCD..G = '3'
		entry b'10100110'        		; .BC..FG = '4'
		entry b'01101110'        		; A.CD.FG = '5'
		entry b'01111110'        		; A.CDEFG = '6'
		entry b'11000010'        		; ABC.... = '7'
		entry b'11111110'        		; ABCDEFG = '8'
		entry b'11101110'        		; ABCD.FG = '9'

		entry b'11110110'        		; ABC.EFG = 'A'
		entry b'00111110'        		; ..CDEFG = 'b'
		entry b'01111000'        		; A..DEF. = 'C'
		entry b'10011110'        		; .BCDE.G = 'd'
		entry b'01111100'        		; A..DEFG = 'E'
		entry b'01110100'        		; A...EFG = 'F'


;**************************************************************************
;                                                                         *
; Procedures                                                              *
;                                                                         *
;**************************************************************************

;--------------------------------------------------------------------------
; polls the pushbuttons and sensors
;--------------------------------------------------------------------------

poll		macro

		decfsz poll_cnt
		goto poll1

		movlw ISR_FREQ/POLL_FREQ		; recharge period
		movwf poll_cnt

		movlw POLL_IO				; input mode
		tris_B

		clrf PORTA				; poll
		movwf PORTB
		nop
		movff PORTB,temp

		movlw PORTB_IO
		tris_B

		bcf _io,_SOUND				; poll sound sensor
		btfsc temp,MIC
		bsf _io,_SOUND

		bcf _io,_LIGHT				; poll light sensor
		btfsc temp,IR
		bsf _io,_LIGHT

		movfw temp				; poll buttons
		xorlw BUTTONS
		xorwf _io,w
		andlw BUTTONS
		xorwf _io

poll1
		endm


;--------------------------------------------------------------------------
; multiplexes the LEDs and 7-segments
;--------------------------------------------------------------------------

mux		macro

		decfsz mux_cnt
		goto mux5

		movlw ISR_FREQ/MUX_FREQ		; recharge period
		movwf mux_cnt

		movlf PORTA_INIT,dataA
		movlf PORTB_INIT,dataB

		movfw _multiplex
		andlw 3
		bz mux1
		xorlw 1
		bz mux2

		movlw ~3
		andwf _multiplex

		bcf ENABLE_LEDS			; LEDs

		movfw _leds

		goto mux4

mux1		bcf ENABLE_HI				; 7-segment high digit

		swapf _7segs,w
		andlw h'0f'
		index bcd_hi

		btfss _multiplex,HI_7SEG
		movlw 0

		goto mux3

mux2		bcf ENABLE_LO				; 7-segment low digit

		movfw _7segs
		andlw h'0f'
		index bcd_lo

		btfss _multiplex,LO_7SEG
		movlw 0

mux3		incf _multiplex

mux4		movwf temp
		andlw LEDS_B
		iorwf dataB
		swapf temp
		rrf temp
		rrf temp,w
		andlw LEDS_A
		iorwf dataA

mux5
		endm


;--------------------------------------------------------------------------
; interrupt service routine
;--------------------------------------------------------------------------

ISR_PERIOD	equ	(CLOCK/4)/ISR_FREQ

		routine isr

		movwf context+0			; save context
		swapf STATUS,w
		movwf context+1

		movlw ISR_PERIOD			; recharge timer
		subwf TMR0

		clrwdt

		incf _timer				; wait timer

		btfss _io,_BUZZER			; buzzer
		goto isr1

		tstf buzzer
		skpnz
		incf buzzer
		decfsz buzzer
		goto isr1

		movlf BUZZER_PITCH,buzzer	; recharge period

		movlw 1<<_SPEAKER			; toggle speaker
		xorwf _io

isr1		movlw PORTA_IO
		btfsc _io,_SPEAKER
		movlw PORTA_IO&~(1<<PIEZO)
		tris_A

		mux						; multiplex LEDs and 7-segments

		poll 					; poll pushbuttons and sensors

		movff dataA,PORTA
		movff dataB,PORTB

		swapf context+1,w			; restore context
		movwf STATUS
		swapf context+0
		swapf context+0,w

		bcf INTCON,T0IF

		retfie


;--------------------------------------------------------------------------
; main entry point
;--------------------------------------------------------------------------

		routine _main_entry

		movlf PORTA_INIT,PORTA		; initialise ports
		movlw PORTA_IO
		tris_A
		movlf PORTB_INIT,PORTB
		movlw PORTB_IO
		tris_B

		movlw PRESCALE
		option_

		clrwdt                        ; clear watchdog timer

		movlf RAM,FSR				; clear all registers
main1	clrf 0
		incf FSR
		movlw MAX
		subwf FSR,w
		bnz main1

		incf poll_cnt
		incf mux_cnt

		clrf TMR0
		decf TMR0

		clrf INTCON				; enable interrupts
		bsf INTCON,GIE
		bsf INTCON,T0IE


;**************************************************************************
;                                                                         *
; User code												    *
;                                                                         *
;**************************************************************************



;**************************************************************************
;                                                                         *
; Library routines											    *
;                                                                         *
;**************************************************************************

;--------------------------------------------------------------------------
; end program
;--------------------------------------------------------------------------

		routine _end_prog

;		bsf STATUS,RP0
;		movlw h'ff'
;		movwf TRISA
;		movwf TRISB
;		bcf STATUS,RP0

end1		clrwdt
		goto end1


;--------------------------------------------------------------------------
; beeps
;--------------------------------------------------------------------------

		routine _beep

		bsf _io,_BUZZER

		movlw d'200'
		call _wait

		bcf _io,_BUZZER

		return


;--------------------------------------------------------------------------
; waits for the number of milliseconds in w (0 to 255)
;--------------------------------------------------------------------------

		routine _wait

		clrf _arg

		goto _long_wait


;--------------------------------------------------------------------------
; waits for the number of milliseconds in _arg:w (0 to 65535)
;--------------------------------------------------------------------------

		routine _long_wait

		clrwdt

		movwf _work1

		movff _timer,_work2

wait1	movfw _work1
		iorwf _arg,w
		bz wait3

		movlw ISR_FREQ/d'1000'
		addwf _work2

wait2	clrwdt
		movfw _timer
		subwf _work2,w
		bnz wait2

		tstf _work1
		skpnz
		decf _arg
		decf _work1

		goto wait1

wait3	return


;--------------------------------------------------------------------------
; multiplication (8-bit _arg * 8-bit wreg -> 8-bit wreg)
;--------------------------------------------------------------------------

		routine _mult8

		movwf _work1

		clrw

mult1	clrc
		rrf _work1

		skpnc
		addwf _arg,w

		clrc
		rlf _arg

		tstf _work1
		bnz mult1

		return


;--------------------------------------------------------------------------
; division (8-bit _arg / 8-bit wreg -> 8-bit wreg)
;--------------------------------------------------------------------------

          routine _div8

		clrf _work1
		bsf _work1,3

          clrf _work2

div1      clrc
          rlf _arg
          rlf _work2

          subwf _work2

		skpnc
		bsf _arg,0

		skpc
          addwf _work2

		decfsz _work1
          goto div1

		movfw _arg

          return


;--------------------------------------------------------------------------
; multiplication (16-bit _arg1 * 16-bit _arg2 -> 16-bit _arg1)
;--------------------------------------------------------------------------

		routine _mult16

		movlf d'16',_work1

		clrf _work2
		clrf _work3

mult2	rrf _arg1+0
		rrf _arg1+1
		bnc mult3

		movfw _arg2+1
		addwf _work3
		skpnc
		incf _work2
		movfw _arg2+0
		addwf _work2

mult3    	clrc
		rlf _arg2+1
		rlf _arg2+0

		decfsz _work1
		goto mult2

		movff _work2,_arg1+0
		movff _work3,_arg1+1

		return


;--------------------------------------------------------------------------
; division (16-bit _arg1 / 16-bit _arg2 -> 16-bit _arg1)
;--------------------------------------------------------------------------

		routine _div16

		movlf d'16',_work1

		clrf _work2
		clrf _work3

div2      clrc
		rlf _arg1+1
		rlf _arg1+0
		rlf _work3
		rlf _work2

		movfw _work2               	; compare numerator with denominator
		subwf _arg2+0,w
		bnc div3
		bnz div4
		movfw _arg2+1
		subwf _work3,w
		bnc div4                      ; branch if numerator < denominator

div3      bsf _arg1+1,0

		movfw _arg2+1                	; subtract denominator from numerator
		subwf _work3
		movfw _arg2+0
		skpc
		incf _arg2+0,w
		subwf _work2

div4      decfsz _work1
		goto div2

		return


		end

