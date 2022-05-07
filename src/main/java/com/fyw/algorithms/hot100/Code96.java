package com.fyw.algorithms.hot100;

/**
 * @Title Code96
 * @Author fyw
 * @Date 2022/5/4 11:10
 * @Description:
 */
public class Code96 {
    public int numTrees(int n) {
        int[] dp=new int[n+10];
        dp[0]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
