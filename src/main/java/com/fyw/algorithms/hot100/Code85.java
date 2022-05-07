package com.fyw.algorithms.hot100;

import java.util.Stack;

/**
 * @Title Code85
 * @Author fyw
 * @Date 2022/5/4 11:10
 * @Description:
 */
public class Code85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]=='1'){
                   if (i>0){
                       dp[i][j]=1+dp[i-1][j];
                   }else{
                       dp[i][j]=1;
                   }
                }
            }
        }

        int res=Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            res=Math.max(res,largestRectangleArea(dp[i]));
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int[] left=new int[heights.length+10];
        int[] right=new int[heights.length+10];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i])
                stack.pop();
            if (stack.isEmpty()){
                left[i]=-1;
            }else{
                left[i]=stack.peek();
            }
            stack.push(i);
        }
        stack=new Stack<>();
        for (int i = heights.length-1; i >=0 ; i--) {
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i])
                stack.pop();
            if (stack.isEmpty()){
                right[i]=heights.length;
            }else{
                right[i]=stack.peek();
            }
            stack.push(i);
        }
        int res=Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            res=Math.max(res,heights[i]*(right[i]-left[i]-1));
        }
        return res;
    }
}
