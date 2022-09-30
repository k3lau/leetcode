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

  static int increasingSubRecursive(int[] inputArr, int index, int[] countArr) {
    if (index == 0) {
      countArr[index] = 1;
    } else {
      for (int j = 0; j < index; j++) {
        if (inputArr[j] < inputArr[index]) {
          countArr[index] += 1;
        }
      }
      // countArr[index] += countArr[index - 1];
    }
    int result = countArr[index];
    if (index < inputArr.length - 1) {
      result += increasingSubRecursive(inputArr, index + 1, countArr);
    }

    return result;
  }

  public static void main(String[] args) {
    // int[] inputArr = { 3, 5, 6, 8, 9, 3, 2, 1, 2, 3 };

    // System.out.println(increasingSubsequence(inputArr));
    int[] inputArr = { 3, 5, 2, 8 };
    // int[] countArr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] countArr = new int[] { 0, 0, 0, 0 };
    System.out.println((increasingSubRecursive(inputArr, 0, countArr)));
  }
}
