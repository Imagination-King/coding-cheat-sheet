public class FactorialDemo {
  public static void main(String[] args) {
    int num = Integer.parseInt(args[0]);
    factorial(num);
    factorial(num, 0);
  }

  /*
   * Recurtion:
   * To be a recursive function, the function must have a base case and a reduction step.
   * BASE CASE is the point at which the recursion stops and an actual value is calculated.
   * REDUCTION STEP must eventually cause the base case to be fulfilled.
   * If it helps, think of it like a loop. There has to be some sort of counter that is constantly
   * incremented, otherwise the program will be stuck in the loop forever.
   */
  public static long factorial(int n) { // Clean version
    if (n == 1) { // base case
      return 1;
    }
    return n * factorial(n - 1); // reduction step
  }
  
  public static long factorial(int n, int indent) { // Function Trace version
    String spaces = "  ".repeat(indent);
    System.out.println(spaces + "factorial(" + n + ")");

    if (n == 1) { // base case
      System.out.println(spaces + "return 1");
      return 1;
    }

    long subResult = factorial(n - 1, indent + 1); // reduction step
    long result = n * subResult;
    System.out.println(spaces + "return " + n + " * " + subResult + " = " + result);
    return result;
  }

  
}
