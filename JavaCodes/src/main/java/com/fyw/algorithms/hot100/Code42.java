package com.fyw.algorithms.hot100;

/**
 * @Title Code42
 * @Author fyw
 * @Date 2022/5/3 11:56
 * @Description:
 */
public class Code42 {
    public int trap(int[] height) {
        if (height==null||height.length==0)
            return 0;
        int res=0;
        int n=height.length;
        int[] left=new int[n+1];
        int[] right=new int[n+1];
        left[0]=height[0];
        right[n-1]=height[n-1];
        for (int i = 1; i < n; i++) {
            left[i]=Math.max(left[i-1],height[i]);
        }
        for (int i = n-2; i >=0 ; i--) {
            right[i]=Math.max(right[i+1],height[i]);
        }
        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

}
