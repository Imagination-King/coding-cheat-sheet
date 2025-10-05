public class BubbleSort {
  public static void main(String[] args) {
    int[] numberz = new int[10];
    // Populate the array with random numbers between 0 and 100
    int x = 0;
    while (x < 10) {
      numberz[x] = (int) (Math.random() * 100);
      x++;
    }

    // Print the array
    x = 0; // reset x to 0
    while (x < 10) {
      System.out.print(numberz[x] + " ");
      x++;
    }
    System.out.println();

    /*
     * Bubble Sort
     * The bubble sort goes through the array, and sort of pushes the largest number
     * to the back of the array. While it doesn't have many real world applications,
     * it's a good way to understand how nested loops work.
     *
     * First loop to hit everything in the array, except for the final spot, because
     * that spot will be sorted long before this loop gets there.
     */
    for (int i = 0; i < numberz.length - 1; i++) { //
      /*
       * This second loop will go through the array again, but one less time for every
       * time we go through the main loop. These will be the numbers we're actually
       * comparing
       */
      for (int j = 0; j < numberz.length - i - 1; j++) {
        // Simple number swap
        if (numberz[j] > numberz[j + 1]) {
          int temp = numberz[j];
          numberz[j] = numberz[j + 1];
          numberz[j + 1] = temp;
        }
      }
    }

    // Print the sorted array
    x = 0; // reset x to zero
    while (x < 10) {
      System.out.print(numberz[x] + " ");
      x++;
    }
  }
}
