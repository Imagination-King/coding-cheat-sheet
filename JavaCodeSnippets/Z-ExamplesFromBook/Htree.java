import ExternalLibs.StdDraw;

public class Htree {
  public static void draw(int n, double size, double x, double y) { // Draw an H-tree centered at x, y
    // of depth n and given size.
    if (n == 0)
      return;
    double x0 = x - size / 2, x1 = x + size / 2;
    double y0 = y - size / 2, y1 = y + size / 2;
    StdDraw.line(x0, y, x1, y);
    StdDraw.line(x0, y0, x0, y1);
    StdDraw.line(x1, y0, x1, y1);
    draw(n - 1, size / 2, x0, y0);
    draw(n - 1, size / 2, x0, y1);
    draw(n - 1, size / 2, x1, y0);
    draw(n - 1, size / 2, x1, y1);
    StdDraw.pause(500); // slowed down to watch
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    draw(n, 0.5, 0.5, 0.5);
  }
}
// The function draw() draws three lines, each of length size, in the shape of
// the letter H, centered
// at (x, y). Then, it calls itself recursively for each of the four tips,
// halving the size argument
// in each call and using an integer argument n to control the depth of the
// recursion.