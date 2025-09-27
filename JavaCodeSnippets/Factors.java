/*
 * This program takes a positive integer n and prints the prime 
 * factorization of n.
 */

import java.util.Scanner;

public class Factors {
  public static void main(String[] args) { // Print the prime factorization of n.
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number you want the prime factors of: ");
    long n = input.nextLong(); // NOTE: Still not testing for input validation
    for (long factor = 2; factor <= n / factor; factor++) { // Test potential factor.
      while (n % factor == 0) { // Cast out and print factor.
        n /= factor;
        System.out.print(factor + " ");
      } // Any factor of n must be greater than factor.
    }
    if (n > 1) {
      System.out.print(n);
    }
    System.out.println();

    input.close();
  }
}