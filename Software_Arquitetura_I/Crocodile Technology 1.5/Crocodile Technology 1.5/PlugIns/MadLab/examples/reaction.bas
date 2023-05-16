
' reaction timer

' button #1 starts count after random time interval
' button #1 stops count and displays reaction time
' count stops at 99
' player loses if button pressed too early
' button #2 resets


symbol MIN_REACT = 8
symbol MAX_REACT = 60


	let Digits = %00000000

loop1:	let random = MIN_REACT

loop2:	pause 1

	let random = random + 1
	if random >= MAX_REACT then loop1

	if Button2 = 1 then reset

	if Button1 = 0 then loop2

	let Digits = %00000000

loop3:	pause 50

	if Button1 = 1 then loop3

loop4:	pause 50

	if Button2 = 1 then reset

	let react = 99
	if Button1 = 1 then loop6

	let random = random - 1
	if random <> 0 then loop4

	let react = 0

loop5:	let react = react + 1

loop6:	let temp = react / 10
	let temp = temp * 6
	let Digits = react + temp

	pause 4

	if react = 99 then timeout

	if Button2 = 1 then reset

	if Button1 = 0 then loop5

loop7:	pause 50

	if Button1 = 1 then loop7

	goto loop1


reset:
	let Digits = %00000000

res1:	pause 50

	if Button2 = 1 then res1

	goto loop1


timeout:
	' beep
	pause 50
	' beep

tout1:	pause 50

	if Button2 = 0 then tout1

	goto reset


	end
