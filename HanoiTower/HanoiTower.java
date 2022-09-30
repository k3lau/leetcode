import java.util.*;

public class HanoiTower {

  static void solveHanoiTower(List<Integer> current, List<Integer> target, List<Integer> other, int num) {
    // If the number being moved isn't at the top of the current stack,
    // solve for the next one to be moved to the other stack.
    // This will recurse the call until num = 1
    if (current.indexOf(num) != (current.size() - 1)) {
      solveHanoiTower(current, other, target, num - 1);
    }

    current.remove(current.size() - 1);
    target.add(num);

    System.out.println(current.toString());
    System.out.println(target.toString());
    System.out.println(other.toString());
    System.out.println("");

    // After move the number to the target, complete the tower by
    // finding the lower number and move to the current stack
    if (num != 1) {
      solveHanoiTower(other, target, current, num - 1);
      System.out.println(current.toString());
      System.out.println(target.toString());
      System.out.println(other.toString());
      System.out.println("");
    }
  }

  public static void main(String[] args) {
    int num = 4;
    List<Integer> A = new ArrayList<Integer>();
    List<Integer> B = new ArrayList<Integer>();
    List<Integer> C = new ArrayList<Integer>();
    for (int i = num; i > 0; i--) {
      A.add(i);
    }
    solveHanoiTower(A, B, C, num);
    System.out.println(A.toString());
    System.out.println(B.toString());
    System.out.println(C.toString());
  }
}
