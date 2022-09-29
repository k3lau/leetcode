public class Tiling2ByNBoard {
  /*
   * Suppose that you are tiling a 2 x n (2 rows, columns) grid/board
   * with the following pieces that you cannot rotate.
   * Find a recursive formula to compute the number of tilings of the 2 x n board
   * using any number of the pieces above so that no two black square pieces are
   * stacked on top of each other.
   */
  static int[] cacheResult = new int[11];

  static int tile(int col) {
    if (col == 1) {
      // blue-blue, blue-black, black-blue
      return 3;
    }
    if (col == 2) {
      // field 4 cells with singles or 1 3-piece and 1 single
      // With singles, each 2x1 board can field 3 ways as above in (col == 1) case
      // So fielding only with singles will have 3 x 3 = 9 ways
      // With 1 3-piece and 1 single, there are 4 ways
      // Total of 13 ways
      return 13;
    }
    if (cacheResult[col] != 0) {
      return cacheResult[col];
    }
    // In 3 columns, it can start with 2x1 or 2x2
    int result = 3 * tile(col - 1) + 4 * tile(col - 2);
    cacheResult[col] = result;
    return cacheResult[col];
  }

  public static void main(String[] args) {

    System.out.println(tile(1));
    System.out.println(tile(2));
    System.out.println(tile(3));
    System.out.println(tile(4));
    System.out.println(tile(10));
  }
}
