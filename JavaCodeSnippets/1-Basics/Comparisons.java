public class Comparisons {
  public static void main(String[] args) {
    /*
     * Comparing booleans is easy!
     */
    boolean T = true;
    boolean F = true;
    System.out.println(T && F); // if there's at least one truth in an AND (&&), the whole thing is true
    System.out.println(T || F); // if there's at least one false in an OR (||), the whole thing is false
    System.out.println(!T); // the NOT (!) operator reverses the boolean

    /*
     * Comparing numerical primitives usually acts as expected, even if they are
     * different primitives (i.e. ints and doubles). Java will automatically "widen"
     * the smaller of the two primitives so that the comparison is between two of
     * the same type. However, it is important to note that sometimes comparing two
     * floating point numbers with <=, >=, or == can produce unexpected results due
     * to rounding errors. If you face this issue, the problem can be easily solved
     * with absolute values.
     */
    int x = 2;
    int y = 6;
    double a = 2.0;
    if (x < y)
      System.out.println("X < Y");
    else if (x > y)
      System.out.println("X > Y");
    else if (x == y)
      System.out.println("X = Y");

    if (x < a)
      System.out.println("X < A");
    else if (x > a)
      System.out.println("X > A");
    else if (x == a)
      System.out.println("X = A");

    double b = 2.000000001;
    if (a == b)
      System.out.println("A = B");
    else if (Math.abs(a - b) < .00001) // The margin of error can be whatever you want
      System.out.println("A ~ B");

    /*
     * Comparing Strings is pretty simple, too, though you'll need the
     * String.equals() function. It returns true only if the Strings are the exact
     * same sequence of characters.
     */
    String one = "This is a string";
    String two = "This is a string "; // Notice the space
    String three = "This is a string";
    if (one.equals(two))
      System.out.println("same");
    else
      System.out.println("not the same");

    if (one.equals(three))
      System.out.println("same");
    else
      System.out.println("not the same");

    /*
     * There's also a String.compareTo() function useful for sorting Strings
     * alphanumerically. It returns negative if the first string is lower
     * (alphanumerically) than the second, and returns positive if the first string
     * is
     * higher (alphanumerically) than the second. 0 is returned if they're
     * identical.
     * There's an ignore case version too if you need it.
     */
    String four = "20";
    String five = "Z";
    System.out.println(one.compareTo(four));
    System.out.println(one.compareToIgnoreCase(five));

    /*
     * Comparing arrays requires using loops to go through and comparing the
     * contents of both arrays. Otherwise, you're just going to compare the memory
     * addresses of the arrays, and that's almost never helpful.
     */
    String[] arr1 = { "This", "is", "only", "a", "test" };
    String[] arr2 = { "This", "is", "only", "a", "test" };
    
    // Neither of these will produce the desired result, so don't do it
    // System.out.println(arr1.equals(arr2));
    // System.out.println(arr1 == arr2);
    
    boolean test = true;
    if (arr1.length != arr2.length) // quick test to avoid OOB errors
      test = false;
    else {
      for (int i = 0; i < arr1.length; i++) {
        if (!arr1[i].equals(arr2[i])) { // reminder to use == if dealing with numeric arrays
          test = false;
          break;
        }
      }
    }
    System.out.println(test); // this will actually give you what you're looking for
  }
}
