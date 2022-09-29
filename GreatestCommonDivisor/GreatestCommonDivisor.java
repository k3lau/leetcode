public class GreatestCommonDivisor {
  private static int greatestCommonDivisor(int x, int y) {
    if (x < y) {
      int temp = x;
      x = y;
      y = temp;
    }
    if (x % y == 0) {
      return y;
    } else {
      for (int i = y - 1; i > 1; i--) {
        if (y % i == 0 && x % i == 0) {
          return i;
        }
      }
      return 1;
    }
  }

  private static int greatestCommonDivisorRecursive(int x, int y, int decrement) {
    if (x < y) {
      int temp = x;
      x = y;
      y = temp;
    }

    if (x % y == 0) {
      return y;
    } else {
      if (decrement > 0 && y % (y - decrement) == 0 && x % (y - decrement) == 0) {
        return y - decrement;
      } else {
        return greatestCommonDivisorRecursive(x, y, decrement + 1);
      }
    }
  }

  private static int greatestCommonDivisorRecursive(int x, int y) {
    return greatestCommonDivisorRecursive(x, y, 0);
  }

  private static int euclideanGreatestCommonDivisor(int x, int y) {
    // Ensure x is always greater than y
    if (x < y) {
      int temp = x;
      x = y;
      y = temp;
    }

    if (x % y == 0) {
      return y;
    } else {
      return euclideanGreatestCommonDivisor(y, x % y);
    }
  }

  public static void main(String[] args) {
    // (10, 5) return 5
    // (15, 9) return 3
    // (101, 100) return 1
    // (1482, 819) return 39
    System.out.println(greatestCommonDivisor(10, 5));
    System.out.println(greatestCommonDivisor(15, 9));
    System.out.println(greatestCommonDivisor(101, 100));
    System.out.println(greatestCommonDivisorRecursive(10, 5));
    System.out.println(greatestCommonDivisorRecursive(15, 9));
    System.out.println(greatestCommonDivisorRecursive(101, 100));
    System.out.println(greatestCommonDivisorRecursive(1482, 819));
    System.out.println(euclideanGreatestCommonDivisor(1482, 819));
    System.out.println(euclideanGreatestCommonDivisor(10, 5));
    System.out.println(euclideanGreatestCommonDivisor(15, 9));
    System.out.println(euclideanGreatestCommonDivisor(101, 100));
  }
}
