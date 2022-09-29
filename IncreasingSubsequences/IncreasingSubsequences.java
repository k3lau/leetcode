import java.util.*;

public class IncreasingSubsequences {

  static int calculateSeq(int length) {
    return length * (length - 1) / 2;
  }

  static void printSeq(int[] inputArr, int[] sequence) {
    for (int i = sequence[0]; i < sequence[1]; i++) {
      for (int j = sequence[1]; j > i; j--) {
        if (j > i) {
          System.out.println(Arrays.toString(Arrays.copyOfRange(inputArr, i, j + 1)));
        }
      }
    }
  }

  static int increasingSubsequence(int[] inputArr) {
    List<int[]> sequenceEnd = new ArrayList<>();
    int start = 0, end = inputArr.length - 1;
    for (int i = 1; i < inputArr.length; i++) {
      if (inputArr[i] < inputArr[i - 1]) {
        end = i - 1;
        if (end > start) {
          sequenceEnd.add(new int[] { start, end });
        }
        start = i;
      } else {
        end = i;
      }
    }
    if (end > start) {
      sequenceEnd.add(new int[] { start, end });
    }
    int countSeq = 0, length;
    for (int i = 0; i < sequenceEnd.size(); i++) {
      length = calculateSeq(sequenceEnd.get(i)[1] - sequenceEnd.get(i)[0] + 1);
      countSeq += length;
      printSeq(inputArr, new int[] { sequenceEnd.get(i)[0], sequenceEnd.get(i)[1] });
    }
    return countSeq;
  }

  public static void main(String[] args) {
    int[] inputArr = { 3, 5, 6, 8, 9, 3, 2, 1, 2, 3 };
    System.out.println(increasingSubsequence(inputArr));
  }
}
