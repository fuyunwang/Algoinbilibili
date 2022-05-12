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
    static class Code525{
    }
    static class Code560{
    }
    static class Code724{
    }
    static class Code926{

    }
    static class Code930{
    }
    static class Code974{
    }

    static class Code1052{
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int sum=0;
            for (int i = 0; i < customers.length; i++) {
                if (grumpy[i]==0){
                    sum+=customers[i];
                    // 擦除策略
                    customers[i]=0;
                }
            }
            int res=sum;
            for (int i = 0; i < customers.length; i++) {
                if (i<minutes){
                    sum+=customers[i];
                }else{
                    sum+=customers[i];
                    sum-=customers[i-minutes];
                }
                res=Math.max(res,sum);
            }
            return res;
        }
    }
}
