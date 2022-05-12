package com.fyw.algorithms.subarray;

/**
 * @Title Code1004
 * @Author fyw
 * @Date 2022/5/12 19:08
 * @Description:
 */
public class Code1004 {
    public int longestOnes(int[] nums, int k) {
        int res= 0;
        int cnt=0;  // 表示当前翻转次数
        for (int i = 0,j=0; i < nums.length; i++) {
            if (nums[i]==0){
                cnt++;
            }
            while (cnt>k){
                if (nums[j]==0)
                    cnt--;
                j++;
            }
            res=Math.max(res,i-j+1);
        }
        return res;
    }
}
