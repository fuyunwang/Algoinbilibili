package com.fyw.algorithms.hot100;

/**
 * @Title Code55
 * @Author fyw
 * @Date 2022/5/4 10:51
 * @Description:
 */
public class Code55 {
    public boolean canJump(int[] nums) {
        int end=0;
        for (int i = 0; i < nums.length; i++) {
            if (end<i)
                return false;
            end=Math.max(end,nums[i]+i);
        }
        return true;
    }
}
