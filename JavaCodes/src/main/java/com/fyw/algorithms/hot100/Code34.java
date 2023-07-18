package com.fyw.algorithms.hot100;

import java.util.Arrays;

/**
 * @Title Code34
 * @Author fyw
 * @Date 2022/5/3 11:55
 * @Description:
 */
public class Code34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums==null||nums.length==0)
            return new int[]{-1,-1};
        int[] res=new int[2];
        Arrays.fill(res,-1);
        int l=0,r=nums.length-1;
        // 如果我们查找左侧边界，我们从大于等于target值的方面考虑
        while (l<r){
            int mid=l+r>>1;
            if (nums[mid]>=target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        if (target==nums[l])
            res[0]=l;
        // 如果我们查找右侧边界，我们从小于等于target值的方面考虑
        l=0;
        r=nums.length-1;
        while (l<r){
            int mid=l+r+1>>1;
            if (nums[mid]<=target){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        if (target==nums[l])
            res[1]=l;
        return res;
    }
}
