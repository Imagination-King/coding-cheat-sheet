/*
 * This library comprises three important functions for manipulating color:
 * monochrome luminance, conversion to grayscale, and background/foreground compatibility.
 */

import java.awt.Color;

import ExternalLibs.*;

public class Luminance {
  public static double intensity(Color color) { // Monochrome luminance of color.
    int r = color.getRed();
    int g = color.getGreen();
    int b = color.getBlue();
    return 0.299 * r + 0.587 * g + 0.114 * b;
  }

  public static Color toGray(Color color) { // Use luminance to convert to grayscale.
    int y = (int) Math.round(intensity(color));
    Color gray = new Color(y, y, y);
    return gray;
  }

  public static boolean areCompatible(Color a, Color b) { // True if colors are compatible, false otherwise.
    return Math.abs(intensity(a) - intensity(b)) >= 128.0;
  }

  public static void AlbersSquares(Color a, Color b) { // Draws 2 squares inside 2 larger squares
    StdDraw.setPenColor(a);
    StdDraw.filledSquare(0.25, 0.5, 0.2);
    StdDraw.setPenColor(b);
    StdDraw.filledSquare(0.25, 0.5, 0.1);
    StdDraw.filledSquare(0.75, 0.5, 0.2);
    StdDraw.setPenColor(a);
    StdDraw.filledSquare(0.75, 0.5, 0.1);
  }

  public static void main(String[] args) { // Are the two specified RGB colors compatible?
    int[] a = new int[6];
    for (int i = 0; i < 6; i++)
      a[i] = Integer.parseInt(args[i]);
    Color c1 = new Color(a[0], a[1], a[2]);
    Color c2 = new Color(a[3], a[4], a[5]);
    StdOut.println(areCompatible(c1, c2));
    AlbersSquares(c1, c2);
  }
}