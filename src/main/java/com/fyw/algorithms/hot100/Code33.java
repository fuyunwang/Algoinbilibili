package com.fyw.algorithms.hot100;

/**
 * @Title Code33
 * @Author fyw
 * @Date 2022/5/3 11:55
 * @Description:
 */
public class Code33 {
    public int search(int[] nums, int target) {
        if (nums==null||nums.length==0)
            return -1;
        int n=nums.length;
        int l=0,r=n-1;
        while (l<r){
            int mid=l+r+1>>1;
            if (nums[mid]>=nums[0]){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        if (nums[l]==target){
            return l;
        }
        if (nums[0]>target){
            l=l+1;
            r=n-1;
        }else{
            l=0;
        }
        while (l<r){
            int mid=l+r>>1;
            if (nums[mid]>=target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        if (nums[r]==target)
            return r;
        return -1;
    }
}
