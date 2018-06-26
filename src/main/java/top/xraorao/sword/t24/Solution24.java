package top.xraorao.sword.t24;

/**
 * 二叉搜索树的后序遍历序列.
 *
 * @author Xiong Raorao
 * @since 2018-05-13-23:12
 */
public class Solution24 {

  private boolean verify(int[] sequence, int first, int last) {
    if (last - first <= 1) {
      return true;
    }
    int rootVal = sequence[last];
    int cutIndex = first;
    while (cutIndex < last && sequence[cutIndex] <= rootVal) {
      cutIndex++;
    }
    for (int i = cutIndex + 1; i < last; i++) {
      if (sequence[i] < rootVal) {
        return false;
      }
    }
    return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);
  }

  public boolean VerifySquenceOfBST(int[] sequence) {

    if (sequence == null || sequence.length == 0) {
      return false;
    }
    return verify(sequence, 0, sequence.length - 1);
  }

}
