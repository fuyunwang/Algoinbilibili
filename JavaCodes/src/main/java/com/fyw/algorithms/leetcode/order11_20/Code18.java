package com.fyw.algorithms.leetcode.order11_20;

import java.util.*;

/**
 * @Title Code18
 * @Author fyw
 * @Date 2022/5/13 22:09
 * @Description:
 */
public class Code18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1])
                continue;
            for (int j = i+1; j < nums.length; j++) {
                if (j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                for (int k = j+1,u=nums.length-1; k < u; k++) {
                    if (k>j+1&&nums[k]==nums[k-1])
                        continue;
                    while (k<u-1&&nums[i]+nums[j]+nums[k]+nums[u-1]>=target)
                        u--;    // 探测的过程
                    if (nums[i]+nums[j]+nums[k]+nums[u]==target)
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[u]));
                }
            }
        }
        return res;
    }
}
