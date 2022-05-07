package com.fyw.algorithms.hot100;

import java.util.Arrays;
import java.util.Map;

/**
 * @Title Code64
 * @Author fyw
 * @Date 2022/5/4 10:51
 * @Description:
 */
public class Code64 {
    public int minPathSum(int[][] grid) {
        if (grid==null||grid.length<1||grid[0].length<1)
            return 0;
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0&&j==0){
                    dp[i][j]=grid[i][j];
                }
                if (i!=0){
                    dp[i][j]= Math.min(dp[i][j],dp[i-1][j]+grid[i][j]);
                }

                if (j!=0){
                    dp[i][j]= Math.min(dp[i][j],dp[i][j-1]+grid[i][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
