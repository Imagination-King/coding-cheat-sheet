public class FunWithVars {
  public static void main(String[] args) {
    /*
     * Java has 8 main data types (often called primitives, though
     * Strings aren't technically primitives). Below are simple demos for each.
     * Keep in mind, IDENTIFIERS refer to the name of the variable
     * and LITERALS refer to the value of the variable. So in
     * var = 10, var is the identifier and 10 is the literal.
     * 
     * Identifiers are case sensitive and must only contain letters,
     * numbers, underscores (_) or dollar signs ($). They also can't
     * start with a number.
     */

    /*
     * 1. int - Integers
     * Can be any whole number between -2^31 and (2^31 -1) (inclusive)
     * If you need to turn a double or float into an int, you must cast
     * it, and keep in mind casting has a high priority level in the
     * order of operations. ex. int x = (int) 2.37
     */
    System.out.println("----INTS----");
    int i1 = 25;
    System.out.println("Int 1: " + i1);
    int i2 = -36;
    System.out.println("Int 2: " + i2);
    // Keep PEMDAS in mind when dealing with numbers!
    System.out.println("i1 + i2 = " + (i1 + i2)); // evaluates to -11
    System.out.println("i1 + i2 = " + i1 + i2); // evaluates to 25-36
    // Division of integers cuts off anything past decimal.
    System.out.println("5 / 4 = " + (5 / 4)); // evaluates to 1 instead of 1.25
    // Remainder would give the rest if you need it
    System.out.println("5 % 4 = " + (5 % 4)); // evaluates to 1

    // Parsing ints and doubles is covered in String section



    /*
     * 2. double - floating point numbers
     * For when you need precise numbers. Works much like ints.
     * Ints can auto switch to doubles when necessary, but doubles can't auto
     * switch back to ints due to the potential loss in data.
     * NOTE: float is a valid primitive, but it has less precision than doubles,
     * and most people just ignore it.
     */
    System.out.println("\n----DOUBLES----");
    double d1 = 20; // Java will auto add a decimal here
    System.out.println("Double 1: " + d1);
    double d2 = 3.14;
    System.out.println("Double 2: " + d2);
    double d3 = 6.022e23; // Scientific notation also accepted. This is "6.022 x 10^23"
    System.out.println("Double 3: " + d3);
    System.out.println("d1 * d2 = " + (d1 * d2)); // evaluates to 62.800..4
    /*
     * Sometimes the computer makes rounding errors, resulting in the 4 at the
     * end of the previous answer. Usually doesn't cause too much of an issue,
     * but it's probably smart practice to round the decimals off.
     */
    System.out.printf("d1 * d2 = %.1f%n", (d1 * d2)); // printf will be covered elsewhere

    // Parsing ints and doubles is covered in String section



    /*
     * 3. boolean - True/False
     * Can only be true or false. Operators are && (and), || (or), and ! (not).
     * I'm not writing out the whole logic chart here. You know how this works.
     * Comparisons between other data types covered in Comparisons.java.
     */
    System.out.println("\n----BOOLEANS----");
    boolean b1 = true;
    boolean b2 = false;
    System.out.println("True and False: " + (b1 && b2)); // true
    System.out.println("True or False: " + (b1 || b2)); // false
    System.out.println("Not True: " + (!b1)); // false



    /*
     * 4. String - strings of alphanumeric characters, symbols, and white spaces
     * Always surrounded by double quotes. You can use the escape character (\)
     * to add things like quotation marks, white spaces, and other reserved
     * characters.
     */
    System.out.println("\n----STRINGS----");
    String s1 = "Hello, World! ";
    String s2 = "This is how you add \"quotes\".";
    String s3 = "\nAnd this is on a new line.";
    System.out.println(s1 + s2 + s3); // concatentation is easy!

    // You can also turn numbers in strings back into integers or doubles if need
    // be.
    String s4 = "123";
    System.out.println("Is this 123 + 25? " + (s4 + 25));
    int stringInt = Integer.parseInt(s4); // turn "123" into 123
    System.out.println("No, this is 123 + 25: " + (stringInt + 25));
    double stringDub = Double.parseDouble(s4); // turn "123" into 123.0
    System.out.println("No, this is 123 + 25: " + (stringDub + 25));



    /*
     * 5. char - single characters
     * Usually restricted to alphanumeric characters, though symbols and
     * white space characters are also allowed. Must be surrounded by
     * single quotes.
     */
    System.out.println("\n----CHARS----");
    char c1 = 'A';
    char c2 = '\t';
    System.out.println(c1); // prints the captial letter 'A'
    System.out.println("This is a tab" + c2 + " See?"); // prints a tab

    // Warning: chars don't concatenate unless they're cast into String or there's
    // another String in the concat chain. Otherwise, it's an addition with Unicode.
    System.out.print(c1 + c1); // prints 1305
    System.out.print(" Oops. That should have been \"AA\"\n" + c1 + c1 + " That's better\n");

    // If assigning numbers to char, things get a little weird. They actually
    // point to Unicode values. Take a look
    System.out.println("\nAssigning numbers to chars:");
    char c3 = '5';
    char c4 = 5;
    System.out.println(c3); // prints 5
    System.out.println((int) c3); // prints 53
    System.out.println(c4); // prints nothing
    System.out.println((int) c4); // prints 5

    /*
     * Strange isn't it? Kind of, but no. '5' is treated as a CHARACTER LITERAL and
     * 5 is
     * an INTEGER LITERAL. In both cases, Java is interpreting both into their
     * Unicode assignments, so the integer 5 is U+0005 (which isn't a printable
     * char)
     * and '5' (which is treated as a symbol that happens to look like 5) is U+0035
     * (decimal # 53).
     * 
     * Integer Literal = raw number
     * Character Literal = symbol
     */



    /*
     * The last three all act pretty much like int, but have
     * different inclusive bounds
     * 
     * 6. byte - limits are -128 and 127
     * 7. short - limits are -32,768 and 32,767
     * 8. long - limits are -2^63 and (2^63 -1)
     */
  }
}
