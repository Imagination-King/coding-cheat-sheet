# Welcome to:
## Alex Hamilton's
# Computer Science Cheat Sheet

In this document will be a collection of tips, tricks, and whatever else I feel would be useful to know.
If you browse the project folder, you'll find mini programs and code snippets that demonstrate various helpful things.

MARKDOWN
Need some Markdown help? [text](https://www.markdownguide.org/basic-syntax/)

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
-> Triangle == demo of StdDraw
-> ConcertA == demo of StdAudio
-> Hate2Love == JOptionPane (pop up text boxes)

Folder 3: Beyond Main (Methods, Recursion, Data Types)
-> FactorialDemo == example of recursion
-> TimeOfDay == an interface and 2 data types, meant to showcase creation of data types and inheritance
-> DataStructuresDemo == demos for single linked lists, stacks, and queues
-> BSTDemo == demo of a BinarySearchTree

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
-> Luminance == small library to test compatibility of colors
-> Turtle == turtle drawing library
-> Spiral == draws recursive spirals using Turtle library
-> SortArray == demos of both insertion sort (brute force) and merge sort (linearithmic)
-> ST and Lookup == Symbol Table and partner Lookup classes

Universal Tips & Tricks
- If the programming problem seems too complicated at first, start breaking it down into bite-sized chunks. Even the complex problems can be solved with the right combination of basic boolean logic and well-placed loops.
- Some languages, like Java don't care about indentation and spacing, treating all white space equal. Some languages, like Python on the other hand, very much do care.
- Most languages will only accept specific types of data in each data primitive, and will throw errors if you violate those rules. Some languages, like Python, won't stop you from assigning bad values, so keep an eye out and TRACK YOUR VARIABLES!
- Operators (+,-,*,/,&&,||, etc.) are almost always evaluated in order of precedence (think PEMDAS) from left to right. The assignment operator (=) is always evaluated last.
- If and if/else statements technically don't need brackets if the body of the loop is only one line
  - Use them anyway. It's good practice, and helps with readability.
- When dealing with loops, you can use BREAK to prematurely end a loop or CONTINUE to skip to the next iteration of the loop. However, as Dondi always said, a smart programmer shouldn't need either.
- Have a chain of IF-ELSE statements? Try using a SWITCH statement.
- Break large programs down into smaller methods. It helps with debugging and readability.
- Keeping track of a variable's SCOPE is especially important when dealing with multiple methods.
- Functions can pass variable by either VALUE or REFERENCE. Passing by value sends a copy of the variable. Passing by reference sends the variable itself. Be aware of which you are doing.
  - Java always passes by value, however, for Objects (incl arrays), the value that is passed is the reference. This behavior is somewhat unique among the different languages.
- RECURSION (having a function call itself) is a very powerful, very helpful tool, though at some point you will need a BASE CASE that stops the recursion and actually outputs a value.
- DYNAMIC PROGRAMMING is coding in a way that causes the computer to remember recursive values its already computed, so it doesn't have to keep computing them every single time.
  - For example: storing the values in an array like arr[i] = recursive[i]
  - You can use either Bottom-Up or Top-Down dynamic programming, depending on the situation **(I might cover these in their own demo program)**
- A LIBRARY is a class (module*) filled with methods meant to be used by other programs.
  - When designing libraries, the main method is often used for debugging purposes.
  - CLIENTS are programs/programmers that call upon a library's functions.
  - APIs (Application Programming Interface) show the client how to use the functions (inputs, outputs).
  - IMPLEMENTATION code is the logic behind the functions.
  - Because the way functions are implemented (how they work) can change drastically between versions, the client-facing API should focus more on WHAT the function does than HOW it does it.
  - for some professional examples of libraries, check out the ExternalLibs folder
  * MODULE refers to any piece of code that can be compiled and run independantly
- DATA ABSTRACTION: creating your own custom data types and the methods that can be used on them. There's already thousands of already existing data types in every object-oriented language, but you can always make your own if you want.
- STATIC vs INSTANCE: static methods are for libraries, instance methods are for data types. Math.random() is a static method, while Arrays.toString() is an instance method.
- SAFE POINTERS: some lanugages like Java, ensure that there's only one way to create pointers / references (with the `new` keyword) and only one way to manipulate the pointer / reference (with the assignment statement). Other languages aren't so strict, so if you find yourself manipulating pointers in other languages, be careful!
- THINK OF THE ORPHANS: By assigning and reassigning variable names to objects, it's possible to completely remove all references to an object. For example:
    int[] a = {1, 2, 3};
    int[] b = {4, 5, 6};
    b = a;
  The {4, 5, 6} array still exists in memory, but there is now no way to access it because we reassigned its pointer to look at the {1, 2, 3} array. Some languages (like Java) don't care if you do this, they'll gladly overwrite orphaned data, but not every language (like C and C++) will, so watch out!
- MUTABLE data types are designed so that they hold a series of changing values, like arrays.
- IMMUTABLE data types are designed so that the values they hold won't change, like Strings. This isn't to say they can't be changed, rather any "changes" are actually more akin to a "replacement."
  - If you truly never want a data value to change, use the keyword `final`. Once a `final` variable is given a value, it can never change, accidentally or otherwise (unless you attempt to use `final` on a mutable data type or a reference type, like an array).
- EFFICIENCY: you can think about making the program efficient, but don't waste time optimizing it before it's even completed. However, be aware that efficient answers may be better and easier to implement than brute force answers.
- SYMBOL TABLES: tables made of key-value pairs that have a wide range of usage in both the digital and real worlds
  - Key: a simple unique value (often a String or int) used to represent the location of a piece of data
  - Value: the data value represented by the key
    - Examples of key-value pairs are Names and Phone Numbers in a phone book, Words and Definitions in a dictionary, URLs and Websites on the internet, or even File Names and Files on a computer

- While these tips use the Java commands, similar features exist for every language
  - Want to send output to a file instead of the CLI? Use `java ProgramName > [args] fileName`
    - Try pasting this into the terminal: `java .\JavaCodeSnippets\1-Basics\HelloWorld.java >data.txt`
  - Similarly, to read data from a file, use `java ProgramName < fileName`
  - If you have a two way communication between files, use `java Program1 | java Program2`. This would be the same as typing `java Program1 > fileName` and `java Program2 < fileName`
  - Some standard filters (programs that convert standard input to standard output) include sort `java Program | sort` which sorts the output, grep `grep x < Program` which prints every line from the program that contains x, and more `java Program | more` which prints until your screen is full, then waits for you to hit the space bar before printing more
