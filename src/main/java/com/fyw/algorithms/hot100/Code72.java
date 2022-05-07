package com.fyw.algorithms.hot100;

import java.util.Arrays;

/**
 * @Title Code72
 * @Author fyw
 * @Date 2022/5/4 10:51
 * @Description:
 */
public class Code72 {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+10][n+10];
        word1=" "+word1;
        word2=" "+word2;
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i)==word2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
                }
            }
        }
        return dp[m][n];
    }
}
