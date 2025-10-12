package Alexandria;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickPrompt {
  private static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    /*
     * This class is designed to automate the prompt and get process for all
     * primitives. Each function is overloaded so you can optionally provide
     * prompting messages, input files, or neither.
     * 
     * There's also a random number generator that can accept both a min and max
     * 
     * If prompt message and input file are provided, both are used.
     * If only prompt message is provided, input file defaults to the terminal.
     * If only input file is provided, message defaults to null.
     * If neither are provided, prompt message is automated and terminal is used.
     */
    Object[] answers = new Object[5];
    answers[0] = askInt();
    answers[1] = askDouble();
    answers[2] = askFloat();
    answers[3] = askLong();
    answers[4] = ask();
    System.out.println(Arrays.toString(answers));
  }

  /* -----Ints----- */

  public static int askInt() {
    return askInt("Enter an int: ", input);
  }

  public static int askInt(String message) {
    return askInt(message, input);
  }

  public static int askInt(Scanner fileIn) {
    return askInt(null, fileIn);
  }

  public static int askInt(String message, Scanner fileIn) {
    while (true) {
      System.out.print(message);
      try {
        return Integer.parseInt(fileIn.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid integer!");
      }
    }
  }

  /* -----Doubles----- */

  public static double askDouble() {
    return askDouble("Enter a double: ", input);
  }

  public static double askDouble(String message) {
    return askDouble(message, input);
  }

  public static double askDouble(Scanner fileIn) {
    return askDouble(null, fileIn);
  }

  public static double askDouble(String message, Scanner fileIn) {
    while (true) {
      System.out.print(message);
      try {
        return Double.parseDouble(fileIn.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid double!");
      }
    }
  }

  /* -----Floats----- */

  public static float askFloat() {
    return askFloat("Enter a float: ", input);
  }

  public static float askFloat(String message) {
    return askFloat(message, input);
  }

  public static float askFloat(Scanner fileIn) {
    return askFloat(null, fileIn);
  }

  public static float askFloat(String message, Scanner fileIn) {
    while (true) {
      System.out.print(message);
      try {
        return Float.parseFloat(fileIn.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid float!");
      }
    }
  }

  /* -----Longs----- */

  public static long askLong() {
    return askLong("Enter a long: ", input);
  }

  public static long askLong(String message) {
    return askLong(message, input);
  }

  public static long askLong(Scanner fileIn) {
    return askLong(null, fileIn);
  }

  public static long askLong(String message, Scanner fileIn) {
    while (true) {
      System.out.print(message);
      try {
        return Long.parseLong(fileIn.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid long!");
      }
    }
  }

  /* -----Characters----- */

  public static char askChar() {
    return askChar("Enter a char: ", input);
  }

  public static char askChar(String message) {
    return askChar(message, input);
  }

  public static char askChar(Scanner fileIn) {
    return askChar(null, fileIn);
  }

  public static char askChar(String message, Scanner fileIn) {
    while (true) {
      System.out.print(message);
      String s = input.nextLine().trim();
      if (s.length() == 1) { // if inputted string is only 1 char long
        return s.charAt(0);
      }
      System.out.println("Please only enter a single character!");
    }
  }

  /* -----Strings----- */

  public static String ask() {
    return ask("Enter a String: ", input);
  }

  public static String ask(String message) {
    return ask(message, input);
  }

  public static String ask(Scanner fileIn) {
    return ask(null, fileIn);
  }

  public static String ask(String message, Scanner fileIn) {
    System.out.print(message);
    return fileIn.nextLine();
  }

  /* -----Booleans----- */
  // This is the only one I can't think of a good reason to ask for with only an
  // input file specified
  public static boolean askYN() {
    return askYN("(Y/N): ", input);
  }

  public static boolean askYN(String message) {
    return askYN(message, input);
  }

  public static boolean askYN(String message, Scanner fileIn) {
    while (true) {
      System.out.print(message);
      String response = input.nextLine().trim().toUpperCase();

      if (response.equals("y") || response.equals("yes"))
        return true;
      if (response.equals("n") || response.equals("no"))
        return false;

      System.out.println("Please enter 'yes' or 'no'");
    }
  }

  /* -----Random Numbers----- */

  public static int grabRandInt() {
    return grabRandInt(0, 0);
  }
  
  public static int grabRandInt(int max) {
    return grabRandInt(max, 0);
  }

  public static int grabRandInt(int max, int min) {
    Random rand = new Random();
    if (max == min)
      return rand.nextInt();
    return rand.nextInt(max + 1) + min;
  }

  public static double grabRandDouble() {
    return grabRandDouble(0, 0);
  }

  public static double grabRandDouble(double max) {
    return grabRandDouble(max, 0);
  }

  public static double grabRandDouble(double max, double min) {
    Random rand = new Random();
    if (max == min)
      return rand.nextDouble();
    return rand.nextDouble(max + 1) + min;
  }
}