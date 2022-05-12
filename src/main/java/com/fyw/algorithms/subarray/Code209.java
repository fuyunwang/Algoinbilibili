package com.fyw.algorithms.subarray;

/**
 * @Title Code209
 * @Author fyw
 * @Date 2022/5/12 18:45
 * @Description:
 */
public class Code209 {
    public int minSubArrayLen(int target, int[] nums) {
        int preSum=0;
        int res=Integer.MAX_VALUE;
        for (int i = 0,j=0; i < nums.length; i++) {
            preSum+=nums[i];
            while (preSum-nums[j]>=target)
                j++;
            if (preSum>=target)
                res=Math.min(res,i-j+1);
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
