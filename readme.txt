Welcome to:
Alex Hamilton's
Computer Science Cheat Sheet

In this document will be a collection of tips, tricks,
and whatever else I feel would be useful to know.
If you browse the project folder, you'll find mini programs
and code snippets that demonstrate various helpful things.

List of Code Snippets:

JAVA
Need Java support in VS Code? Go here: https://code.visualstudio.com/docs/java/java-tutorial

Basic Demos/Instructions
-> HelloWorld.java == gotta start somewhere, might as well be the beginning
-> FunWithVars.java == Java's 8 primitives
-> HelpfulFuntions.java == list of some pre-built functions to make life easier
-> UseArgument.java == passing arguments to code through CLI
-> Comparisons.java == // still need to do at some point
-> LoopityLoops.java == all the loops
-> TestGrades.java == 2 dimensional arrays
-> FormattingStrings.java == printf command
-> Triangle.java == demo of StdDraw
-> ConcertA.java == demo of StdAudio
-> Hate2Love.java == JOptionPane (pop up text boxes)

Examples from the book
-> Factors.java == print prime factorization
-> PowersOfTwo.java == lists powers of 2
-> PrimeSieve.java == counting prime factors
-> PlayThatTune.java == plays music samples

Universal Tips & Tricks
- If the programming problem seems too complicated at first, start breaking it down into
  bite-sized chunks. Even the complex problems can be solved with the right combination of
  basic boolean logic and well-placed loops.
- Some languages, like Java don't care about indentation and spacing, treating all white space
  equal. Some languages, like Python on the other hand, very much do care.
- Most languages will only accept specific types of data in each data primitive, and will
  throw errors if you violate those rules. Some languages, like Python, won't stop you
  from assigning bad values, so keep an eye out and TRACK YOUR VARIABLES!
- Operators (+,-,*,/,&&,||, etc.) are almost always evaluated in order of precedence (think
  PEMDAS) from left to right. The assignment operator (=) is always evaluated last.
- If and if/else statements technically don't need brackets if the body of the loop is only
  one line, but best practices say always include brackets.
- When dealing with loops, you can use "break" to prematurely end a loop or "continue" to
  skip to the next iteration of the loop. However, as Dondi always said, a smart programmer
  doesn't need either.
- Have a chain of "if-else" statements? Try using a "switch" statement. These will need the
  "break" statements though.
- While these tips use the Java commands, similar features exist for every language
  - Want to send output to a file instead of the CLI? Use "java ProgramName > [args] fileName"
    Try pasting this into the terminal: java .\JavaCodeSnippets\HelloWorld.java >data.txt
  - Similarly, to read data from a file, use "java ProgramName < fileName"
  - If you have a two way communication between files, use "java Program1 | java Program2"
    This would be the same as typing "java Program1 > fileName" and "java Program2 < fileName"
  - Some standard filters (programs that convert standard input to standard output) include sort
    (java Program | sort) which sorts the output, grep (grep x < Program) which prints every line
    from the program that contains x, and more (java Program | more) which prints until your
    screen is full, then waits for you to hit the space bar before printing more
