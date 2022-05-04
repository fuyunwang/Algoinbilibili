package com.fyw.algorithms.hot100;

/**
 * @Title Code33
 * @Author fyw
 * @Date 2022/5/3 11:55
 * @Description:
 */
public class Code33 {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int r=n-1;
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
        // 在左半部分查找
        int temp=l;
        l=0;
        r=r-1;
        while (l<r){
            int mid=l+r+1>>1;
            if (nums[mid]<=target){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        if (nums[l]==target){
            return l;
        }
        // 在右半部分查找
        l=temp+1;
        r=n-1;
        while (l<r){
            int mid=l+r+1>>1;
            if (nums[mid]<=target){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        if (nums[l]==target){
            return l;
        }
        return -1;
    }

}
