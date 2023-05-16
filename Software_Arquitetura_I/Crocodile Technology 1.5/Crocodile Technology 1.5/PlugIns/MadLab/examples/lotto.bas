
' National Lottery number generator

' button #1 generates unique random numbers from 1 to 49
' stops when 6 numbers have been generated
' button #2 resets


symbol BALL_START = 49
symbol BALL_FINISH = 43

symbol used = 31
symbol temp = EEDATA


	gosub clear_balls

loop1:	pause 50

	if Button2 = 1 then loop2

	if range = BALL_FINISH then loop1

	if Button1 = 1 then loop4

	goto loop1

loop2:	let Digits = 0

loop3:	pause 50

	if Button2 = 1 then loop3

	gosub clear_balls

	goto loop1

loop4:	let random = 0

loop5:	let Digits = %00000000

loop6:	let temp = 15

loop7:	pause 1

	let random = random + 1
	if random < range then loop8
	let random = 0

loop8:	let temp = temp - 1
	if temp <> 0 then loop7

	if Button1 = 0 then loop9

	let Digits = Digits + %00010001
	if Digits = %10101010 then loop5

	goto loop6

loop9:	gosub get_ball

	let temp = ball / 10
	let temp = temp * 2
	let Digits = ball + temp
	let Digits = Digits + temp
	let Digits = Digits + temp

	let range = range - 1

	goto loop1


clear_balls:

	let range = BALL_START

	let FSR = used
clrb1:	let INDF = 0
	let FSR = FSR + 1
	if FSR <> 80 then clrb1:

	return


get_ball:

	let ball = 1
	let FSR = used

getb1:	if INDF = 1 then getb2

	if random = 0 then getb3
	let random = random - 1

getb2:	let ball = ball + 1
	let FSR = FSR + 1
	goto getb1

getb3:	let INDF = 1
	return


	end
