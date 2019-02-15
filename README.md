# Java paint
You're given the task of writing a simple console version of a drwaing program. The functionality of the program is quite limite but should be extensible. The program should work as follows:

1. create new canvas.
2. start drwaing on the canvas by issuing various commands.
3. quit.

The program should support the followings commands:

| Command          | Description                                                                                          |
|------------------| :--------------------------------------------------------------------------------------------------- |
| `C w h`          | Should create a new canvas  of width w and height h. |
| `L x1 y1 x2 y2`  | Should create a new line from `(x1,y1)` to `(x2,y2)`. Currently only horizontal or vertical lines are<br /> supported. Horizontal and vertical lines will be drawn using the x character. |
| `R x1 y1 x2 y2`  | Should create a new rectangle, whose upper left corner is `(x1,y1)` and lower corner<br /> is `(x2,y2)`. Horizontal and vertical lines will be drawn using the x character. |
| `B x y c`        | Should fill the entire area connected to `(x,y)` with colour `'c'`. The behaviour of this is the same<br /> as that of the "bucket fill" tool in paint programs. |
| `Q`              | Should quit the program. |

# Sample I/O
Below is a sample of the output your program should produce. User input is prefixed with `enter command:`:
	
`enter command: C 20 4`
`--------------------`
`| 					  |`
`| 					  |`
`| 					  |`
`| 					  |`
`--------------------`
	
