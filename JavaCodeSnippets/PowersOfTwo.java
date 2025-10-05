import java.util.Scanner;

public class PowersOfTwo {

  public static void main(String[] args) {
    // Setting up the Scanner class to watch the keyboard
    Scanner input = new Scanner(System.in);
    // Asking for user input
    System.out.print("How many powers of two would you like? ");
    // Next user inputted value turned into int
    // NOTE: This currently provides no input validation, so if anything outside the
    // range 0 <= n < 31 is entered, the program won't work properly.
    int n = input.nextInt();
    // Initial value so we always start at 2^0
    int power = 0;
    
    // Loop runs until power passes user inputted value
    while (power <= n) {
      // Take note that Math.pow() produces doubles, so I'm just casting value back into an int
      // Not strictly necessary, but only done for readability
      System.out.println("2 to the power of " + power + " = " + ((int) Math.pow(2, power)));

      // Don't forget to increment control variable for the while loop!
      power++;
    }

    // the for loop version of this would look like:
    // for (power = 0; power <= n; power++) {
    // System.out.println("2 to the power of " + power + " = " + ((int) Math.pow(2, power)));
    // }

    // Not strictly necessary, but it's good practice to close any Scanner links at
    // the end of the program
    input.close();
  }
}