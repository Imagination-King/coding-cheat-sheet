import ExternalLibs.StdDraw;

public class Triangle {
  public static void main(String[] args) {
    double t = Math.sqrt(3.0) / 2.0; // just saving you from typing this again later

    StdDraw.line(0.0, 0.0, 1.0, 0.0); // first line, bottom of triangle
    StdDraw.line(1.0, 0.0, 0.5, t); // second line, right side of triangle
    StdDraw.line(0.5, t, 0.0, 0.0); // third line, left side of triangle
    StdDraw.setPenRadius(.01); // resize brush
    StdDraw.point(0.5, t / 3.0); // black dot in the center
  }
}