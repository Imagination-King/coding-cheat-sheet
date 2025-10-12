package Alexandria;
import java.util.Arrays;
import java.util.Random;

/*
* IMPORTANT note about function calls:
* Parameters must be in the EXACT same order in the function call as they are
* in the method declaration. So, if your method args is a String, an int, and a
* double, then your function call must specify a String, an int, and a double
* in that order.
*/

public class FunctionalArrays {
  // Useless info: as long as you keep the String[] parameter as a String[] in the
  // main method, you can call it whatever you want?
  public static void main(String[] whateverYouWant) {
    /*
     * Notice the only thing main does is accept an integer from the command line
     * and prints a few messages. It doesn't even really create the array, it leaves
     * all of the heavy lifting to its helper functions.
     */
    int n = Integer.parseInt(whateverYouWant[0]);
    int[] arr = createArray(n); // Passes n to createArray function, gets back a whole array
    System.out.println("Original Array:");
    printArray(arr);
    sortArray(arr);
    System.out.println("Sorted Array:");
    printArray(arr);
    shuffleArray(arr);
    System.out.println("Reshuffled Array:");
    printArray(arr);
  }

  /*
   * This function accepts an integer from main, finishes creating the array by
   * providing the length, and then asks another function to come up with some
   * random values for it, only providing a maximum and minimum value, which it
   * also relies on another function to get.
   */
  public static int[] createArray(int length) {
    // Notice that the n from main gets renamed to length here
    int[] m = maxMin(); // go to maxMin, store result in m
    int[] arr = new int[length];
    for (int i = 0; i < length; i++) {
      arr[i] = QuickPrompt.grabRandInt(m[0], m[1]); // pass values from m[], store result in arr[i]
    }
    return arr; // pass arr back to main function
  }

  /*
   * This function doesn't ask for anything from the function that calls it, only
   * returns an int[] with length 2
   */
  private static int[] maxMin() {
    int[] m = new int[2];
    System.out.println(
        "I'm about to ask for two values. If you input the same number on both, there will be no limits on your random numbers");
    m[0] = QuickPrompt.askInt("Maximum value: ");
    m[1] = QuickPrompt.askInt("Minimum value: ");
    return m; // Returns m to createArray function
  }

  /*
   * Just a normal bubble sort, accepting arr from main. And because we're using
   * arrays, it doesn't actually have to return it, because passing arrays only
   * passes the memory address.
   * 
   * Bubble Sorts are designed to "push" the largest numbers towards the end.
   */
  public static void sortArray(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) { // whole length of array
      for (int j = 0; j < arr.length - i - 1; j++) { // this is executed 1 less time every time
        if (arr[j] > arr[j + 1]) { // if the current value is bigger than the next value, flip them
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  /*
   * Similar thing to sortArray, except we're shuffling this time with the
   * Fisher-Yates method.
   * 
   * The Fisher-Yates method starts at the back of the array and switches values
   * based on a random index between 0 and the current i.
   */
  public static void shuffleArray(int[] arr) {
    Random random = new Random();
    for (int i = arr.length - 1; i > 0; i--) {
      int rand = random.nextInt(i + 1); // range {0, i}
      int temp = arr[i];
      arr[i] = arr[rand];
      arr[rand] = temp;
    }
  }

  /*
   * Normally, you wouldn't make a single line function like this, but nothing's
   * stopping you either. The more readable your mainline is, the better for
   * everyone.
   */
  public static void printArray(int[] arr) {
    System.out.println(Arrays.toString(arr));
    /*
     * Despite printing something to the terminal, this method still doesn't have a
     * return statement, because it doesn't send anything back to the main method
     */
  }

  /*
   * I wanted to show method recursion, so here's an example that reverses the
   * order of an int[]. Notice that this actually requires two methods, though not
   * all recursions are like this.
   * 
   * The main reverseArray function takes the array, and passes it to its helper
   * function, along with the first and last indexes. Then the helper function
   * will switch the first and the last spots, and continue calling itself,
   * bringing the two indexes closer to each other each time, until they either
   * overlap (in the case of an odd-numbered array) or the start is bigger than
   * the end (in the case of an even-numbered array).
   */
  public static void reverseArray(int[] arr) {
    reverseArrayHelper(arr, 0, arr.length - 1);
  }

  private static void reverseArrayHelper(int[] arr, int start, int end) {
    if (start >= end)
      return;
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    reverseArrayHelper(arr, start + 1, end - 1);
  }
}