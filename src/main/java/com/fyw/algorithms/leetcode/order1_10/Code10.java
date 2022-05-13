package com.fyw.algorithms.leetcode.order1_10;

/**
 * @Title Code10
 * @Author fyw
 * @Date 2022/5/13 15:14
 * @Description:
 */
public class Code10 {
    public boolean isMatch(String s, String p) {
        if (s==null||p==null)
            return false;
        int m=s.length();
        int n=p.length();
        boolean[][] dp=new boolean[m+10][n+10];
        s=" "+s;
        p=" "+p;
        // 初始化边界条件
        dp[0][0]=true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i)=='*')
                dp[0][i]=dp[0][i-2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j)=='.'||p.charAt(j)==s.charAt(i)){
                    dp[i][j]=dp[i-1][j-1];
                }
                if (p.charAt(j)=='*'){
                    if (p.charAt(j-1)!=s.charAt(i)&&p.charAt(j-1)!='.'){
                        dp[i][j]=dp[i][j-2];
                    }else{
                        dp[i][j]=dp[i-1][j]||dp[i][j-2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
