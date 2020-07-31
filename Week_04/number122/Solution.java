package com.cslp.ken.number122;

//买卖股票最佳时机
public class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        maxProfit += prices[i] - prices[i - 1];
      }
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] prices = new int[]{7,6,4,3,1};
    System.out.println(new Solution().maxProfit(prices));
  }
}
