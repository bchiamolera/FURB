
' PICLAB tester

' beeps twice
' LED5, LED6, LED7 on
' sound => display counts up
' BUTTON1 => LED1
' BUTTON2 => LED2
' BUTTON3 => LED3
' BUTTON4 => LED4
' light on IR sensor => LED8


	high Led5
	high Led6
	high Led7

	' beep
	pause 100
	' beep
	pause 100

	let count = 0

loop:	pause 1

	low Led1
	if Button1 = 0 then lbl1
	high Led1

lbl1:	low Led2
	if Button2 = 0 then lbl2
	high Led2

lbl2:	low Led3
	if Button3 = 0 then lbl3
	high Led3

lbl3:	low Led4
	if Button4 = 0 then lbl4
	high Led4

lbl4:	low Led8
	if LightSensor = 0 then lbl5
	high Led8

lbl5:	if SoundSensor = 0 then loop

	let count = count + 1

	gosub show

	pause 250

	goto loop

show:	let tens = count / 10
	let temp = tens * 10
	let units = count - temp

	let Digits = tens * 16
	let Digits = Digits + units

	return
