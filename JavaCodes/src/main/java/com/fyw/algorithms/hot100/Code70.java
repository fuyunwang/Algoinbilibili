package com.fyw.algorithms.hot100;

/**
 * @Title Code70
 * @Author fyw
 * @Date 2022/5/4 10:51
 * @Description:
 */
public class Code70 {
    public int climbStairs(int n) {
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i = 2; i < n; i++) {
            dp[i]+=dp[i-1];
            dp[i]+=dp[i-2];
        }
        return dp[n-1];
    }

}
