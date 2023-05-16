
' counts claps and shows total on 7-segment display

	let count = 0

loop:	pause 1

	if SoundSensor = 0 then loop

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
