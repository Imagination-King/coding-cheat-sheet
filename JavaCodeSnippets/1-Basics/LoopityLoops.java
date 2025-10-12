public class LoopityLoops {
  public static void main(String[] args) {

    /* Just need to print the contents of your array? Try Arrays.toString(array)! */

    /*
     * Classic for loop: initalize counter (usually at 0), set upper bounds, and
     * then increment. Incrementation can use any mathematical function, including
     * addition, subtraction, multiplication, or division (though most times you'll
     * just use single digit addition)
     */
    System.out.println("FOR LOOP");
    for (int i = 0; i < 5; i++) {
      System.out.println("i = " + i);
    }
    System.out.println();

    /* Simple for loops are perfect for iterating through arrays */
    System.out.println("FOR LOOP (ARRAY)");
    String[] colors = { "Red", "Green", "Blue" };
    for (String color : colors) {
      System.out.println("Color: " + color);
    }
    System.out.println();

    /* Or even 2 dimensional arrays, though this'll require nesting loops */
    System.out.println("FOR LOOP (2D ARRAY)");
    String[][] secret = { { "Batman", "Bruce Wayne", "1939" }, { "Superman", "Clark Kent", "1938" } };
    for (int row = 0; row < secret.length; row++) {
      for (int col = 0; col < secret[row].length; col++) {
        System.out.print(secret[row][col] + " | "); // visually separate cells in row with |
      }
      System.out.println();
    }
    System.out.println();

    /*
     * For-Each Loop: Useful for when you need to read all the values out of an
     * array or collection (including ArrayLists, maps, etc.).
     * Note that For-Each loops CANNOT modify an array's contents, only access the
     * values in read-only mode. If you need to modify the array, you'll have to use
     * a normal loop.
     */
    System.out.println("FOR-EACH LOOP");
    int[] scores = { 90, 86, 42, 97, 65, 99, 100 };
    int total = 0;
    for (int s : scores) {
      System.out.print(s + " ");
      total += s;
    }
    double average = total / scores.length;
    System.out.println("\nAVG: " + average);
    System.out.println();

    /*
     * While loop: counter must be initialized before entering the loop, and
     * incremented manually inside the loop, but on the plus side, you can still
     * access your counter outside of the loop. Biggest danger here is accidental
     * infinite looping.
     */
    System.out.println("WHILE LOOP");
    int count = 0;
    while (count < 5) {
      System.out.println("count = " + count);
      count++;
    }
    System.out.println();

    /*
     * Do-While Loop: Pretty much identical to noraml while loops, except that the
     * condition for continuing to loop is at the end, so you'll always perform the
     * loop at least once.
     */
    System.out.println("DO-WHILE LOOP");
    int number = 0;
    do {
      System.out.println("number = " + number);
      number++;
    } while (number < 5);
    System.out.println();

    /*
     * Break statement: instantly get out of a loop without executing any more
     * commands (works on for or while loops)
     */
    System.out.println("BREAK STATEMENT (ENDS AT 4)");
    for (int i = 0; i < 10; i++) {
      if (i == 4) // ends at 4
        break;
      System.out.println("i = " + i);
    }
    System.out.println();

    /*
     * Continue statement: instantly jumps to the next iteration of the loop,
     * effectively skipping the rest of the current go-around
     */
    System.out.println("CONTINE STATEMENT (SKIPS 2)");
    for (int i = 0; i < 5; i++) {
      if (i == 2) // skips 2
        continue;
      System.out.println("i = " + i);
    }

  }
}
