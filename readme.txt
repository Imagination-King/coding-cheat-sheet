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
Folder 1: Basics
-> HelloWorld == gotta start somewhere, might as well be the beginning
-> UseArgument == passing arguments to code through CLI
-> FunWithVars == Java's 8 primitives
-> Comparisons == compare primitives, Strings, and arrays
-> LoopityLoops == all the loops
-> TestGrades == 2 dimensional arrays
-> FormattingStringsa == printf command

Folder 2: 
-> ArrayShuffle == shuffling the content of arrays
-> FactorialDemo == example of recursion
-> Trianglea == demo of StdDraw
-> ConcertA == demo of StdAudio
-> Hate2Love == JOptionPane (pop up text boxes)

Alexandria (Personal Library)
-> FunctionalArrays == demonstration of methods / functions with arrays
-> QuickPrompt == library of prompt/get functions for all primitives

Code Samples from Book
-> Factors == print prime factorization
-> PowersOfTwo == lists powers of 2
-> PrimeSieve == counting prime factors
-> PlayThatTune == plays music samples
-> PlayThatTuneDeluxe == adds static methods to embellish sound of original
-> Htree == visual representation of recursion

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
- If and if/else statements technically don't need brackets if the body of the loop is only one line
  - Use them anyway. It's good practice, and helps with readability.
- When dealing with loops, you can use BREAK to prematurely end a loop or CONTINUE to
  skip to the next iteration of the loop. However, as Dondi always said, a smart programmer
  doesn't need either.
- Have a chain of IF-ELSE statements? Try using a SWITCH statement.
- Break large programs down into smaller methods. It helps with debugging and readability.
- Keeping track of a variable's SCOPE is especially important when dealing with multiple methods.
- Functions can pass variable by either VALUE or REFERENCE. Passing by value sends a copy of the
  variable. Passing by reference sends the variable itself. Be aware of which you are doing.
  - Java always passes by value, however, for Objects (incl arrays), the value that is passed is
    the reference. This behavior is somewhat unique among the different languages.
- RECURSION (having a function call itself) is a very powerful, very helpful tool, though at some
  point you will need a BASE CASE that stops the recursion and actually outputs a value.
- DYNAMIC PROGRAMMING is coding in a way that causes the computer to remember recursive values its
  already computed, so it doesn't have to keep computing them every single time.
  - For example: storing the values in an array like arr[i] = recursive[i]
  - You can use either Bottom-Up or Top-Down dynamic programming, depending on the situation (I might
    cover these in their own demo program)

- A LIBRARY is a class (module*) filled with methods meant to be used by other programs.
  - When designing libraries, the main method is often used for debugging purposes.
  - CLIENTS are programs/programmers that call upon a library's functions.
  - APIs (Application Programming Interface) show the client how to use the functions (inputs, outputs).
  - IMPLEMENTATION code is the logic behind the functions.
  - Because the way functions are implemented (how they work) can change drastically between
    versions, the client-facing API should focus more on WHAT the function does than HOW it does it.
  - for some professional examples of libraries, check out the ExternalLibs folder
  * MODULE refers to any piece of code that can be compiled and run independantly

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
