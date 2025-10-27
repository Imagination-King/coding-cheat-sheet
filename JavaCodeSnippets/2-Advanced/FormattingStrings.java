import ExternalLibs.StdOut;

public class FormattingStrings {
  public static void main(String[] args) {
    /*
     * Printf statements are made of 2 parts: the format string
     * and the conversion specification. Take the below example:
     * The first part is normal String stuff, but notice everything
     * after the % symbol. This indicates what is being formatted.
     * 
     * In this case:
     * 4 represents the minimum padding for the item. So there will be
     * at least 4 spaces reserved in the String for whatever we're
     * printing. (Padding defaults to left side, use negative number
     * for right side padding)
     * 
     * .2 represents the precision on the decimal value, so in this case
     * the decimal will be cut off after two places
     * 
     * f represents what type of value we're formatting, in this case the
     * floating point value of PI. Other options include d (for decimals
     * from integers), e (floating point using scientific notation), s
     * (Strings), and b (booleans). This is often called the conversion code.
     * There are more conversion codes, but you can look them up if need be.
     * 
     * Math.PI is the value to print. Its type must match the conversion
     * code specified by the conversion code.
     */
    StdOut.printf("PI is approximately %4.2f.\n", Math.PI);

    /*
     * It may be useful to know you can stack combinations of these in
     * a string, just make sure you have an equal number of conversion
     * codes and values.
     */

    StdOut.printf("Paycheck 1: $%8.2f\nPaycheck 2: $%8.2f\n", 501.99, 42.);

    /*
     * Makes printing aligned dates a piece of cake. Also, notice the %02d?
     * The 0 actually pads any empty space with 0s
     */
    String[] months = { "January", "February", "March", "April",
        "May", "June", "July", "August",
        "September", "October", "November", "December" };
    for (int i = 0; i < 12; i++) {
      StdOut.printf("%10s %02d, 2025\n", months[i], i+5);
    }
  }
}
