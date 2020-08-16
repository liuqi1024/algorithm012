package com.cslp.ken.number221;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        /**
                         * 如果该位置的值是 1，则dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的dp 值决定。
                         * 具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加1，状态转移方程如下：
                         * dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
                         */
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
