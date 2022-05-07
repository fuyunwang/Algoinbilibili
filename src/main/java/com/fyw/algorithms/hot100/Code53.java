package com.fyw.algorithms.hot100;

/**
 * @Title Code53
 * @Author fyw
 * @Date 2022/5/4 10:51
 * @Description:
 */
public class Code53 {
    public int maxSubArray(int[] nums) {
        if (nums==null||nums.length==0)
            return 0;
        int[] dp=new int[nums.length+10];
        dp[0]=nums[0];
        int res=dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
