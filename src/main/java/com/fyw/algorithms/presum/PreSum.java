package com.fyw.algorithms.presum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Title PreSum
 * @Author fyw
 * @Date 2022/5/12 17:54
 * @Description: 前缀和与差分
 *
 */
public class PreSum {
    /**
     * sum
     * sum[i]-sum[j-1]
     */
    static class Code523{
        public boolean checkSubarraySum(int[] nums, int k) {
            int n=nums.length;
            int[] sum=new int[n+1];
            for (int i = 1; i <= n; i++) {
                sum[i]=sum[i-1]+nums[i-1];
            }
            HashSet<Integer> set=new HashSet<>();
            for (int i = 2; i <= n; i++) {
                set.add(sum[i-2]%k);
                if (set.contains(sum[i]%k)){
                    return true;
                }
            }
            return false;
        }
    }
    static class COde525{
    }
}
