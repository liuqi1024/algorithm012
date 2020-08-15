package com.cslp.ken.number091;

/**
 * s[i] != '0'
 * 如果 s[i-1]s[i] <= 26, 则 dp[i] = dp[i-1] + dp[i-2]
 * 如果 s[i-1]s[i] > 26, 则 dp[i] = dp[i-1], 这是因为 s[i-1]s[i] 组成的两位数无法翻译
 * s[i] == '0'
 * 如果 s[i-1]s[i] <= 26, 则 dp[i] = dp[i-2], 这是因为 s[i] 无法翻译
 * 还有一些情景直接使得整个序列无法被翻译：
 * 相邻的两个 ‘0’
 * 以 ‘0’ 结尾的大于 26 的数字
 * 去除这些限制条件，此题就是爬楼梯的问题了，一次可以爬一步，也可以爬两步，问有多少中方式到达终点。
 */
public class Solution {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = arr[0] == '0' ? 0 : 1;
        // 最后一个数字不为0，就初始化为1
        if (len <= 1) {
            return dp[1];
        }

        for (int i = 2; i <= len; i++) {
            int n = (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0');
            if (arr[i - 1] == '0' && arr[i - 2] == '0') {
                return 0;
            } else if (arr[i - 2] == '0') {
                dp[i] = dp[i - 1];
            } else if (arr[i - 1] == '0') {
                if (n > 26) return 0;
                dp[i] = dp[i - 2];
            } else if (n > 26) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        char c = 'a';
        System.out.println("abc".charAt(0));
        System.out.println(c-0);
        System.out.println(c - '0');
    }
}
