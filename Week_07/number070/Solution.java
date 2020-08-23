package com.cslp.ken.number070;

import java.util.Arrays;

public class Solution {
  public int climbStairs(int n) {
    if (n <= 2) return n;
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < n ; i++) {
      //dp方程式
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    System.out.println(Arrays.toString(dp));
    return dp[n - 1];
  }

  public static void main(String[] args) {
    System.out.println(new Solution().climbStairs(1));
  }
}
