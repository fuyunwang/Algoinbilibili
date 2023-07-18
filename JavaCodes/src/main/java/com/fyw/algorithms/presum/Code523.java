package com.fyw.algorithms.presum;

import java.util.HashSet;

/**
 * @Title Code523
 * @Author fyw
 * @Date 2022/5/12 19:51
 * @Description:
 */
public class Code523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] sum=new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }
        HashSet<Integer> set=new HashSet<>();//每一个索引下对应的前缀和模k的值
        for (int i = 2; i <= n; i++) {
            set.add(sum[i-2]%k);
            if (set.contains(sum[i]%k)){
                return true;
            }
        }
        return false;
    }
}
