package com.cslp.ken.number022;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<String> generateParenthesis(int n) {
    if (n <= 0) return null;
    List<String> result = new ArrayList<>();
    generate(0, 0, n,  "", result);
    return result;
  }

  private void generate(int left, int right, int n, String s, List<String> res) {
    if (left == n && right == n) {
      res.add(s);
      return;
    }
    if (left < n) {
      generate(left + 1, right, n, s + "(", res);
    }
    if (right < left) {
      generate(left, right + 1, n, s + ")", res);
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.generateParenthesis(3));
  }

}
