package com.fyw.algorithms.leetcode.order11_20;

import java.util.*;

/**
 * @Title Code15
 * @Author fyw
 * @Date 2022/5/13 22:08
 * @Description:
 */
public class Code15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1])
                continue;
            for (int j = i+1,k=nums.length-1; j<k;j++) {
                if (j>i+1&&nums[j]==nums[j-1])
                    continue;
                while (k-1>j&&nums[i]+nums[j]+nums[k-1]>=0)
                    k--;
                if (nums[i]+nums[j]+nums[k]==0)
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));

            }
        }
        return res;
    }
}
