package com.fyw.algorithms.hot100;

/**
 * @Title Code11
 * @Author fyw
 * @Date 2022/5/3 11:28
 * @Description:
 */
public class Code11 {
    public int maxArea(int[] height) {
        int res=0;
        for (int left=0,right=height.length-1;left<right;){
            res=Math.max(res,(right-left)*Math.min(height[left],height[right]));
            if (height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }

        return res;
    }
}
