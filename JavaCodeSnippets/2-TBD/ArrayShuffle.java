import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ArrayShuffle {
  public static void main(String[] args) {
    /*
     * It's pretty easy to sort an array, but how would you randomize the order of
     * the elements? There's a couple of ways, depending on what you want to do.
     */
    int[] intArray = new int[10];
    System.out.println("Original Array:");
    for (int i = 0; i < intArray.length; i++) {
      intArray[i] = (int) Math.pow(2, i);
    }
    System.out.println(Arrays.toString(intArray));

    /*
     * The first way, is using the Fisher-Yates method. This is the ideal way to
     * shuffle primitive arrays.
     * Notice the for loop starts at the end of the array and goes backwards,
     * stopping at index 1
     */
    for (int i = intArray.length - 1; i > 0; i--) {
      // Generate a random number between 0 and the current index
      int rand = (int) (Math.random() * i - 1);
      // Normal swapping of two integers
      int temp = intArray[i];
      intArray[i] = intArray[rand];
      intArray[rand] = temp;
    }
    System.out.println("\nShuffled Once:");
    System.out.println(Arrays.toString(intArray));

    /*
     * Notice you can do the same thing with the Random class. There's not really
     * any disadvantage or advantage to using one or the other, since Math.random()
     * calls the Random class, so the randomness will be the same. Some people
     * prefer to use the Random class, due to it providing more user control, but in
     * small projects, it doesn't really matter.
     */
    Random random = new Random();
    for (int i = intArray.length - 1; i > 0; i--) {
      int rand = random.nextInt(i + 1);
      int temp = intArray[i];
      intArray[i] = intArray[rand];
      intArray[rand] = temp;
    }
    System.out.println("\nShuffled Twice:");
    System.out.println(Arrays.toString(intArray));

    /*
     * The final way to shuffle arrays is to use the shuffle method from the
     * Collections class. Be warned, however, that this method does not work on
     * arrays of primitives like ints, doubles, and booleans. So, if you need to
     * shuffle a primitive array, there's some conversion involved.
     */
    Integer[] convertedArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
    Collections.shuffle(Arrays.asList(convertedArray));
    intArray = Arrays.stream(convertedArray).mapToInt(Integer::intValue).toArray();

    System.out.println("\nShuffled Thrice:");
    System.out.println(Arrays.toString(intArray));

  }
}