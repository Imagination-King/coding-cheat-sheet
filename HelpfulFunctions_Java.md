This will be a compilation of various helpful functions from different classes
with some information on usage.

Universal Functions
There's a couple of functions found in the API of every single object (including Strings and arrays) coded in Java. This is because every object in Java is a descendant of the Object class. Their implementations vary based on the object, but their roles stay the same.
Examples based on `Car(String color, String model, int year)`
- The .toString() method is often used as a quick debugging tool to show what values are currently stored in the object. For example, the Arrays' toString puts the contents of an array into a nice, compact String. And yes, even the String data type has a .toString() method, though you'll rarely, if ever, need it, as it just returns the String itself.
  - Car.toString() might print out "Year: `year` Color: `color` Model: `model`"
- The .equals(Object obj) function takes the place of the == operator, since that operator only compares the reference values of objects instead of the objects themselves. The equals() method would be used to go in and compare the actual values stored in the object.
  - Car.equals(Car) would compare the color, model, and year of two Car objects to see if they matched, and would return true if they did
- The .hashCode() method returns an int value representing the hash of the object.
- The .getClass() method will return the name of the class of the object that calls this function.

Arrays
-toString(int[])
returns String
quick way to print the contents of an array without loops
note: 2D arrays need toString called on each row, otherwise
you'll just get the memory addresses instead of the contents

Strings / Printing
-print(String s)
print s
-println()
prints a new line (could also use "\n")
-println(String s)
print s then a new line
-printf(String s)
prints s with some formatting (see
FormattingStrings.java for more info)
-replaceFirst(String s, String a)
regex search for s, replace first instance with a
-String.subString(int i, int j)
returns portion of String starting at i and ending at j-1
Strings, like arrays, start indexing at 0

Wrappers
Each data primitive in Java has a "wrapper" type that allows you to treat the primitive as an object. In addition to granting each primitive access to the universal methods (see above), each wrapper class also has some additional functions. The name of the wrapper class is simply the name of the primitive spelled out, with the first letter being capitalized. (i.e. Integer for int, Boolean for boolean, Character for char, etc.)
- Integer.parseInt(String s)
  converts s to an int
  similar methods available for all numerical primitives
* Note that Java will auto-convert (offcially: box and unbox) primitives to their wrappers and vice-versa whenever it's needed.

Scanner class
-Scanner input = new Scanner();
link an external file for your program to read from
-Scanner input = new Scanner(System.in);
links the keyboard as the "file" to read from
-input.close()
closes the link between the program and the external file

Math class
not functions, but the Math class also has some
helpful constants like Math.E and Math.PI that
contain their arithmatic values.
-abs(int a)
returns INT: absolute value of a
also works for doubles, longs, and floats
-exp(double a)
returns DOUBLE: e^a
-log(double a)
returns DOUBLE: natural log of a
-max(int a, int b)
returns INT: larger of the 2 ints
also works for doubles, longs, and floats
inverse is int min (int a, int b)
-pow(double a, double b)
returns DOUBLE: a^b
-random()
returns DOUBLE: random number x in range 0 <= x < 1
To get a random number between 2 values:
Math.random() \* (max - min) + min;
-round(double a)
returns LONG: a rounded to nearest integer
-sin(double a)
returns DOUBLE: sine of a (in Radians)
similar functions for cosine (cos), tanget (tan),
cosecant (asin), secant (acos), and cotanget (atan)
-sqrt(double a)
returns DOUBLE: square root of a
-toDegrees(double a)
returns DOUBLE: Radian measurement converted to Degrees
similar function toRadians() goes the other way

Color (Object)
-import java.awt.Color
-Color (int r, int g, int b)
new color created by mixing specified values of red,
green, and blue
-brighter()
returns brighter version of current color
-darker()
returns darker version of current color
-getRed()
returns int value of red intensity
also has getGreen() and getBlue() variants

StdDraw
-setCanvasSize(int w, int h)
-setXscale(double x0, double x1)
sets x-axis scale to (x0, x1)
leave args blank to reset to unit square
setYscale has same functionality
-setPenRadius(double r)
sets pen radius to r
leave args empty to reset to .002
-point(double x, double y)
draws a single point at (x,y)
-line(double x1, double y1, doube x2, double y2)
draws a line between points (x1, y1) and (x2, y2)
-circle(double x, double y, double r)
draws a circle centered at (x,y) with radius r
optionally rename to filledCircle
-square(double x, double y, double r)
draws a square centered at (x,y) with side length 2r
optionally rename to filledSquare
-rectangle(double x, double y, double s1, double s2)
draws a rectangle centered at (x,y) with side lengths 2s1 and 2s2
optionally rename to filledRectangle
-polygon(double[x], double[y])
draws a polygon with n sides defined by points defined in the two arrays i.e.
point 1 ( x[0], y[0] ), point 2 ( x[1], y[1] ), etc.
optionally rename to filledPolygon
-text(double x, double y, String s)
prints s originating at point (x,y)
-setFont (Font f)
-setPenColor(Color c)
Note: Font and Color are special data types, some are defined as constants in StdDraw
-enableDoubleBuffering()
causes image to be printed in computer memory only,
meant to help with performance
use show() to transfer drawing to visible canvas
use clear(Color c) to fill canvas with color (white if no color is specified)
-pause (double t)
pauses drawing tasks for t milliseconds

StdAudio
-play(double[] a)
plays given sound
instead provide String fileName to play from .wav file
-save(String fileName, double[a])
save a[] to .wav file
-read(String fileName)
returns DOUBLE[]: read .wav file back into program
