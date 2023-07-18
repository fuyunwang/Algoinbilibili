package com.fyw.algorithms.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title Code15
 * @Author fyw
 * @Date 2022/5/3 11:33
 * @Description:
 */
public class Code15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);  // 对nums进行从小到大排序
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1])
                continue;
            for (int j = i+1,k=nums.length-1; j <k; j++) {
                if (j>i+1&&nums[j]==nums[j-1])
                    continue;
                while (j<k-1&&nums[i]+nums[j]+nums[k-1]>=0)
                    k--;    // 这里过程类似一个探测的过程
                if (nums[i]+nums[j]+nums[k]==0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }
        }
        return res;
    }
}
