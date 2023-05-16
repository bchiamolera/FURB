'**************************************************************************
' FILE:      catcher.bas                                                  *
' CONTENTS:  SpyCatcher				                                  *
' COPYRIGHT: MadLab Ltd. 2000                                             *
' AUTHOR:    James Hutchby                                                *
' UPDATED:   10/09/00                                                     *
'**************************************************************************

' ready state: red LED indicates current light sensor state, green LED indicates sensor mode
' (off = light, on = sound), button1 toggles sensor mode, button2 -> arm state
' arm state: LEDs cycle, timeout -> detect state
' detect state: red LED flashes, sensor active -> trigger state, any button -> ready state
' trigger state: red LED flashes, any button -> ready state, timeout -> alarm state
' alarm state: LEDs flash, alarm sound, any button -> ready state


main:
		let mode = 0


ready_state:
		let timer = 0

		let release = 1

		low RedLed
		low OrangeLed
		low GreenLed
		low YellowLed

ready_loop:
		low GreenLed       				' indicate sensor mode
		if mode = 0 then read1
		high GreenLed

read1:	low RedLed					' indicate light sensor state
		if LightSensor = 0 then read2
		high RedLed

read2:	pause 50

		gosub poll

		if button = 1 then read3
		if button = 2 then arm_state

		goto ready_loop

read3:	let mode = mode ^ 1
		goto ready_loop


arm_state:
		let timer = 0

arm_loop:
		let mask = timer & 3			' cycle LEDs
		if mask <> 0 then arm1
		high YellowLed
arm1:	if mask <> 1 then arm2
		high GreenLed
arm2:	if mask <> 2 then arm3
		high OrangeLed
arm3:	if mask <> 3 then arm4
		high RedLed

arm4:	pause 50

		low YellowLed
		low GreenLed
		low OrangeLed
		low RedLed

		let timer = timer + 1
		if timer < 60 then arm_loop

		' beep                     		' indicate armed
		pause 20
		' beep


detect_state:
		let timer = 0

detect_loop:
		low RedLed

		pause 50

		let timer = timer + 1
		let mask = timer & %11111
		if mask <> 0 then dete1

		high RedLed       				' flash LED

		pause 50

dete1:	if mode <> 0 then dete2

		if LightSensor = 1 then trigger_state

		goto dete3

dete2:	if SoundSensor = 1 then trigger_state

dete3:	gosub poll

		if button <> 0 then dete4

		goto detect_loop

dete4:	let release = 0


trigger_state:
		let timer = 0

		low YellowLed

trigger_loop:
		low RedLed        				' flash LED
		let mask = timer & 3
		if mask <> 0 then trig1
		high RedLed

trig1:	pause 50

		let timer = timer + 1
		if timer > 60 then alarm_state

		gosub poll

		if button = 0 then trigger_loop

		' beep                    		' indicate disarmed
		pause 20
		' beep

		goto ready_state


alarm_state:
		let timer = 0

alarm_loop:
		low RedLed                 		' flash LEDs
		low OrangeLed
		low GreenLed
		low YellowLed
		let mask = timer & 1
		if mask = 0 then alar1
		high RedLed
		high OrangeLed
		goto alar2
alar1:	high GreenLed
		high YellowLed

alar2:	' beep

		pause 50

		let timer = timer + 1

		gosub poll

		if button <> 0 then ready_state

		goto alarm_loop


poll:
		let button = 1
		if Button1 = 1 then poll1
		let button = 2
		if Button2 = 1 then poll1
		let button = 3
		if Button3 = 1 then poll1
		let button = 4
		if Button4 = 1 then poll1
		let button = 0

poll1:    if release = 0 then poll3

		if button <> 0 then poll2
		let release = 0

poll2:	let button = 0

poll3:    if button = 0 then poll4
		let release = 1

poll4:	return


		end

