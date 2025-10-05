public class TestGrades {
  public static void main(String[] args) {
    /*
     * Things to know about arrays:
     * -Java auto-initializes the values in an array if not specified by the user
     * --Numeric arrays get set to 0, booleans are false, and Strings are null
     * 
     * -Initializing arrays requires keyword "new" because Java doesn't inherently
     * know how much memory to allocate to an array, unlike data primitives, which
     * all have set memory limits.
     * --The only time keyword "new" is not needed is when you define the contents
     * of the array at creation: int[] a = {1, 2, 3};
     * 
     * -Unlike other languages, Java will throw errors if you attempt to access
     * spots in the array that don't exist.
     * -Single dimension arrays are sometimes called vectors. Two dimensional arrays
     * are sometimes called matrices (singular: matrix)
     * 
     * -Because of how Java stores 2-D arrays, you can access rows, but not columns.
     * For example: in array a[5][5] you can call a[3] for row 4, but there's no way
     * to access individual columns (because Java stores 2-D arrays as an array of
     * arrays)
     * -There are Ragged Arrays, which means not all rows are the same length. Be
     * careful when looping through them.
     * 
     * -When comparing or passing arrays, you pass the memory address, not the aaray
     * itself. This is important to remember when assigning and comparing arrays.
     * Check bottom of page for example.
     */

    // 2D Array to hold students, test grades, and totals
    String[][] students = {
        { "Sally", "85", "90", "78", null },
        { "Steven", "92", "88", "95", null },
        { "Sue", "80", "68", "74", null },
    };

    // normally, the last spot in an array is length-1, but because of our total
    // column, it's -2 here
    int numTests = students[0].length - 2;

    for (int s = 0; s < students.length; s++) { // loop through rows
      int total = 0; // set (and reset) total to 0 for every student
      for (int t = 1; t <= numTests; t++) { // loop through columns, starting with col 1 to avoid Names
        total += Integer.parseInt(students[s][t]); // convert to int for addition
      }
      // notice how we have to convert the int back to a String to store it in the
      // array
      students[s][numTests + 1] = String.valueOf(total / 3);
    }

    // Print Table
    System.out.println("Name    Test 1  Test 2  Test 3  Total  Grade");
    for (int i = 0; i < students.length; i++) { // only loop through the rows this time

      // calculate final grade
      int finalScore = Integer.parseInt(students[i][students[0].length - 1]);
      char finalGrade;
      if (finalScore <= 60) {
        finalGrade = 'F';
      } else if (finalScore <= 70) {
        finalGrade = 'D';
      } else if (finalScore <= 80) {
        finalGrade = 'C';
      } else if (finalScore <= 90) {
        finalGrade = 'B';
      } else {
        finalGrade = 'A';
      }

      // there are probably better ways to print the whole row...
      // notice the %%? That allows printing the % in printf statements
      System.out.printf("%-8s %3s %7s %7s %7s%% %5c", students[i][0], students[i][1], students[i][2], students[i][3],
          students[i][4], finalGrade);

      System.out.println();

    }

    // /*
    //  * Demonstration of passing memory address for arrays
    //  */

    // String[][] studentCopy = students;
    // // Currently, if we compare these two, they will be equal
    // System.out.print(studentCopy == students); // true
    // System.out.println(studentCopy[0][0].compareTo(students[0][0])); // 0 (true)
    // // However, if we change something in studentCopy, then compare...
    // studentCopy[0][0] = "Robert";
    // System.out.print(studentCopy == students); // true
    // System.out.println(studentCopy[0][0].compareTo(students[0][0])); // 0 (true)
    // /*
    //  * They're still the same?
    //  * 
    //  * That's because we're not passing the array itself, we're passing the
    //  * address where the array lives in memory. So studentCopy and students refer to
    //  * the same array, and changing one will change the other.
    //  * 
    //  * If we want to actually compare the contents of an array, we'd have to loop
    //  * through both arrays and compare each cell individually.
    //  * 
    //  * We'd also need to create another array, because currently studentCopy and
    //  * students are still the same array. So we'd have to:
    //  * 
    //  * I'm using int arrays here, but the concept's the same with any array
    //  */

    // int[] xArray = { 1, 2, 3, 4 };
    // int[] yArray = { 1, 2, 3, 4 };
    // int[] zArray = { 1, 2, 3, 5 };
    // boolean XYsame = true;
    // for (int i = 0; i < xArray.length; i++) {
    //   if (xArray[i] != yArray[i]) {
    //     XYsame = false;
    //   }
    // }
    // boolean XZsame = true;
    // for (int i = 0; i < xArray.length; i++) {
    //   if (xArray[i] != zArray[i]) {
    //     XZsame = false;
    //   }
    // }
    // System.out.print("XY Same: " + XYsame + " XZ Same: " + XZsame);
  }

}
