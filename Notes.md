# Notes

## Elements of Programming

- If the programming problem seems too complicated at first, start breaking it down into bite-sized chunks. Even the complex problems can be solved with the right combination of basic boolean logic and well-placed loops.
- Some languages, like Java don't care about indentation and spacing, treating all white space equal. Some languages, like Python on the other hand, very much do care.
- Most languages will only accept specific types of data in each data primitive, and will throw errors if you violate those rules. Some languages, like Python, won't stop you from assigning bad values, so keep an eye out and TRACK YOUR VARIABLES!
- Operators (+,-,\*,/,&&,||, etc.) are almost always evaluated in order of precedence (think PEMDAS) from left to right. The assignment operator (=) is always evaluated last.
- If and if/else statements technically don't need brackets if the body of the loop is only one line
  - Use them anyway. It's good practice, and helps with readability.
- When dealing with loops, you can use BREAK to prematurely end a loop or CONTINUE to skip to the next iteration of the loop. However, as Dondi always said, a smart programmer shouldn't need either.
- Have a chain of IF-ELSE statements? Try using a SWITCH statement.
- Break large programs down into smaller methods. It helps with debugging and readability.
- Keeping track of a variable's SCOPE is especially important when dealing with multiple methods.

### Connecting Programs Together (CLI)

While these tips use the Java commands, similar features exist for every language

- Want to send output to a file instead of the CLI? Use `java ProgramName > [args] fileName`
  - Try pasting this into the terminal: `java .\JavaCodeSnippets\1-Basics\HelloWorld.java >data.txt`
- Similarly, to read data from a file, use `java ProgramName < fileName`
- If you have a two way communication between files, use `java Program1 | java Program2`. This would be the same as typing `java Program1 > fileName` and `java Program2 < fileName`
- Some standard filters (programs that convert standard input to standard output) include sort `java Program | sort` which sorts the output, grep `grep x < Program` which prints every line from the program that contains x, and more `java Program | more` which prints until your screen is full, then waits for you to hit the space bar before printing more

## Functions and Modules

- Functions can pass variable by either VALUE or REFERENCE. Passing by value sends a copy of the variable. Passing by reference sends the variable itself. Be aware of which you are doing.
  - Java always passes by value, however, for Objects (incl arrays), the value that is passed is the reference. This behavior is somewhat unique among the different languages.
- RECURSION (having a function call itself) is a very powerful, very helpful tool, though at some point you will need a BASE CASE that stops the recursion and actually outputs a value.
- DYNAMIC PROGRAMMING is coding in a way that causes the computer to remember recursive values its already computed, so it doesn't have to keep computing them every single time.
  - For example: storing the values in an array like arr[i] = recursive[i]
  - You can use either Bottom-Up or Top-Down dynamic programming, depending on the situation **(I might cover these in their own demo program)**

## Object-Oriented Programming

- A LIBRARY is a class (module\*) filled with methods meant to be used by other programs.
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

## Algorithms and Data Structures

- EFFICIENCY: you can think about making the program efficient, but don't waste time optimizing it before it's even completed. However, be aware that efficient answers may be better and easier to implement than brute force answers.
- SYMBOL TABLES: tables made of key-value pairs that have a wide range of usage in both the digital and real worlds
  - Key: a simple unique value (often a String or int) used to represent the location of a piece of data
  - Value: the data value represented by the key
    - Examples of key-value pairs are Names and Phone Numbers in a phone book, Words and Definitions in a dictionary, URLs and Websites on the internet, or even File Names and Files on a computer

## Theory of Computing

- FORMAL LANGUAGES (examples use the Binary language)
  - ALPHABET: finite set of symbols (0, 1)
  - STRING: finite sequence of alphabet symbols (01110)
  - FORMAL LANGUAGE: possibly infinite sets of strings for a given alphabet (0, 1, 10, 11, 100, etc.)
  - SPECIFICATION PROBLEM: how do we COMPLETELY and PRECISELY define a formal language? With an informal English definition, a regular expression, or something else entirely? (all binary numbers; `(0|1)*`)
  - RECOGNITION PROBLEM: determining whether or not a given string exists in a given language (1001 is, but 32 isn't)
  - REGULAR LANGUAGE: any language that can be defined with a regular expression (not every formal language is a regular language, but every regular language is a formal language)
- DFA: stands for deterministic finite-state automata, a model of a computer made of a set number of states (either yes or no), a set of transitions dictating movement between the different states (based on input values), and a "tape reader" capable of reading input
  ![DFA Visual Example](/Extras/dfa-example.png)
- NFA: stands for nondeterministic finite-state automata, similar to DFA, except that each state can have transitions that rely on the same input value, or null transitions that can be followed anytime. In practice, the machine uses recursion to test every possible route it could take based on the input.
  ![NFA Visual Example](/Extras/nfa-example.png)
- KLEENE'S THEOREM: REs, DFAs, and NFAs are equivalent models, in the sense that they all characterize regular languages
- TURING MACHINES: abbreviated TM, advanced version of an NFA, can read both left and right on a tape (which is now an infinite tape with # representing blank spots), can also now write to to the tape
  - Speaking of Alan Turing, (re)watch The Imitation Game starring Benedict Cumberbatch. It's really good.
    ![TM Visual Example](/Extras/tm-example) ![Binary Adder TM](/Extras/tm-binary-adder.png) ![Binary Adder Walkthrough](/Extras/tm-binary-adder-example.png)
    _If the above images aren't working, they can also be found in the Extras folder_
- ALGORTIHM: a finite (limited), deterministic (predictable outcome based on input), and effective problem-solving method suitable for implementation as a computer program
- Important aspects of algortihms:
  - Decidability: the ability to recognize Strings that are both in the language and those not in the language
  - Computability: if an algorithm is given x, it will return f(x)
  - By these definitions, we can say that a Turing machine that decides a language or computes a value is an algorithm for that task. This doesn't mean it's the only one, as there are potentially infinite TMs that would also perform the given task, just that it is one of the possible algorithms.
- Universal Turing Machines: TMs that can simulate the operation of another TM on any input (your computer is an example of a UTM, as the Operating System is an algorithm running other algorithms (programs, internal processes, etc) that can, themselves run other algorithms)
- Church-Turing Thesis: any physically realizable computing device can be modeled/simulated by a Turing machine (researchers have attempted to enhance or restrict TMs for years in an attempt to disprove this theory, but no matter what they change, the result can always be simulated by the original version of the TM model)
  - Physically realizable computing device: a machine that could actually be built and operated in the real world, and not just imagined
- Extended Church-Turing Thesis: a TM can efficiently perform any computation that can be described by a physically realizable computing deivce
- Turing Universal / Turing Complete: any computational model that is equivalent (able to recognize the same languages and compute the same functions) to the Turing model (some examples are lambda calculus (created by Alfonso Church, became the secondary basis for Church-Turing Thesis), counter machines, programming languages, DNA computers, home computers, etc.)
- Unsolvable problems: not every problem is solvable with a computer, not just because we don't have powerful enough computers, but because there is no algorithm to find the solution
  - Example: The Halting Problem
    - What it should do: given any program and its input, determine whether the program will HALT (not enter an infinite loop) with that input. We don't care what the outcome is, as long as it produces an outcome.
    - Why it's unsolvable: to solve the problem, we have to run the program and see if it halts. If it halts, then obviously we can say it halts. But what if it doesn't? What if it keeps going? Is it in an infinite loop or is it just taking longer than we expect to compute? Perhaps it will keep going forever if we let it, or perhaps it'll halt if we give it another 5 seconds (or 5 hours, or 5 days, or 5 years...). At what point do we give up and call it? Since we can't definitvely answer that question with an algorithm, we can't solve the halting problem.
  - More examples of unsolvable problems that you're free to reserach: program equivalence, Rice's Theorem, Hilbert's 10th problem, post correspondence problem, anything optimiztion related, etc.
- (Problem) Reduction: a problem _A_ reduces to problem _B_ if a subroutine for _B_ solves problem _A_. Reduction is helpful in loads of places, especially in determining computational time and determining the solvability of a problem.
  - Example (normal): Finding the kth largest item in an array
    - To find the kth largest item in an array, given an array of items and integer k, first we'd sort the array (in asc or desc order, doesn't matter), then just look at index k (or length - k depending on which way you sorted). In this case, we can say the problem of finding the kth largest item _reduces_ to the problem of sorting an array.
  - Example (unsolvable): The Totality Problem
    - What it should do: given any program, determine whether it will enter an infinite loop for any input
    - Why it's unsolvable: it's pretty easy to say that in order to solve this, we just test various inputs on the function until we hit an infinite loop. Sounds easy, but if you think about it, you'll realize the solution to this would require the solution to the halting problem. The totality problem _reduces_ to the halting problem, and since the halting problem is unsolvable, so is the totality problem.
- Intractibility:
- Polynomial-time: algorithm with running time whose worst-case analysis is based on a \* n^b (n is input size, a and b are constants)
  - Problems with polynomial-time algorithms are considered "easy"
- Exponential-time: algorithm with running time whose best-case analysis is based on 2^(a \* n^b)
  - Problems with exponential-time algorithms are considered "difficult"
- Satisfiability Problems
  - Linear equation stsfy: given a set of _n_ linear equations with _n_ variables, find a set of rational values that solves all of the equations
  - Linear inequality stsfy: given a set of _m_ linear inequalities with _n_ variables, find a set of values that solves all of the inequalities
  - Integer linear inequality stsfy: same as above, but answers must be integers
  - Boolean stsfy: given a set of _m_ equations with _n_ boolean variables, find a set of values that solves all of the equations
- NP: the set of ALL search problems (problems whose solutions involve poly-time algs that check if the given solution solves the given problem) (N stands for nondeterminism)
- P: the set of NP that can be solved in poly-time (unlike NP which only cares about the possibility of solving the problem, P cares about the difficulty of solving the problem)
- Intractable: if there is no known poly-time alg to solve a given problem (i.e. the problem is not in P)
  Known Intractable and P problems:
  |Intract | P |
  |---|---|
  |longest path | shortest path |
  |factoring | multipllication |
  |Boolean Stsfy | LE Stsfy |
  |ILI Stsfy | LI Stsfy |
- P = NP? : No one has been able to identify a definitive way to determine whether a search problem is in P or is intractible, so we know every P is NP, but we don't know if every NP is P.
  - This is where reduction comes back. If problem _A_ poly-time reduces (i.e. the time spent in _A_ is restriceted to poly-time before it goes) to problem _B_, which then evaluates in poly-time, then we can say problem _A_ is in P.
- NP-Complete: search problem _B_ is NP-complete if every search problem _A_ poly-time reduces to _B_
- NP-Hard: a problem is NP-hard if all problems in NP reduce to it
- Dumbed-down way to think about NP, P, NP-Complete, and NP-Hard, borrowed from u/Prcrstntr on Reddit:
  > **P** - problems that a computer can solve 'quickly'
  >
  > **NP** - problems that a computer can check an answer 'quickly'.
  >
  > For example, coloring a map in 3 colors. You can check to see if any touching countries have the same colors just by comparing each country with the others, but you're going to have a much harder time trying to figure out the colors in the first place.
  >
  > **NP-Complete\*** - A bunch of problems in NP that if you figure out how to solve one of these problems quickly, then you can solve the rest of them quickly.
  >
  > **NP-Hard** - A group of problems that if you can figure out how to solve one quickly, then you can solve any NP problem quickly.
  >
  > So far nobody has shown if it is possible to solve any NP problem quickly.
  > [Original Comment](https://www.reddit.com/r/algorithms/comments/7kybyz/comment/dryr4my/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button)
