package com.fyw.algorithms.leetcode.order11_20;

import java.util.Arrays;

/**
 * @Title Code16
 * @Author fyw
 * @Date 2022/5/13 22:09
 * @Description:
 */
public class Code16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res=0x3f3f3f;
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1])
                continue;
            for (int j = i+1,k=nums.length-1; j <k; ) {
                int temp=nums[i]+nums[j]+nums[k];
                res=Math.abs(target-temp)<Math.abs(target-res)?temp:res;
                if (temp>target){
                    k--;
                }else if (temp<target){
                    j++;
                }else{
                    return target;
                }
            }
        }
        return res;
    }
}
