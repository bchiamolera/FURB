
' plays 4 different tones when pushbuttons pressed

loop:	let period = 1
	if Button1 = 1 then play

	let period = 2
	if Button2 = 1 then play

	let period = 3
	if Button3 = 1 then play

	let period = 4
	if Button4 = 1 then play

	low Speaker

	pause 20

	goto loop

play:	let count = 5

play1:	high Speaker

	pause period

	low Speaker

	pause period

	let count = count - 1
	if count <> 0 then play1

	goto loop
