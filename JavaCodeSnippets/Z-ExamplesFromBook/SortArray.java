import ExternalLibs.StdIn;
import ExternalLibs.StdOut;

public class SortArray {
  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length);
  }

  public static void insertionSort(Comparable[] a) { // Sort a[] into increasing order.
    /*
     * This version of the sort method is closer to the traditional bubble sort in
     * efficiency, but operates a little differently. This one incrementally looks
     * at each item in the array, compares it to all the items preceding it, and
     * places it in the correct spot accordingly.
     * 
     * If a[] is already in order (or mostly in order) this method is pretty
     * efficient, but the more random the initial order of a[] is, the longer this
     * method will take.
     */
    int n = a.length;
    for (int i = 1; i < n; i++)
      // Insert a[i] into position.
      for (int j = i; j > 0; j--)
        if (a[j].compareTo(a[j - 1]) < 0)
          exchange(a, j - 1, j);
        else
          break;
  }

  public static void exchange(Comparable[] a, int i, int j) {
    Comparable temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }

  private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) { // Sort a[lo, hi).
    /*
     * This version of the sort method operates similarly to a binary search, where
     * the array is recursively split in halves until there's only two elements,
     * which it sorts, and then merges them back into the array as the recursive
     * calls come off the stack.
     * 
     * Notice, in terms of efficiency, this one is far superior to insertionSort(),
     * at least when given an array of random values.
     */
    if (hi - lo <= 1)
      return;
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid, hi);
    int i = lo, j = mid;
    for (int k = lo; k < hi; k++)
      if (i == mid)
        aux[k] = a[j++];
      else if (j == hi)
        aux[k] = a[i++];
      else if (a[j].compareTo(a[i]) < 0)
        aux[k] = a[j++];
      else
        aux[k] = a[i++];
    for (int k = lo; k < hi; k++)
      a[k] = aux[k];
  }

  public static void main(String[] args) {
    // Read strings from standard input, sort them, and print.
    String[] a = StdIn.readAllStrings();
    sort(a);
    for (int i = 0; i < a.length; i++)
      StdOut.print(a[i] + " ");
    StdOut.println();
  }
}