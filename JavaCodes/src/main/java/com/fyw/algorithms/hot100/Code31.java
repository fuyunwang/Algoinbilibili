package com.fyw.algorithms.hot100;

/**
 * @Title Code31
 * @Author fyw
 * @Date 2022/5/3 11:55
 * @Description:
 */
public class Code31 {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int k=n-2;
        while (k>=0&&nums[k]>=nums[k+1])
            k--;
        if (k<0){   // 整个序列都是降序的
            reverse(nums,0,n-1);
        }else{
            int l=k+1;
            int r=n-1;
            while (l<r){
                int mid=l+r+1>>1;
                if (nums[mid]>nums[k])
                    l=mid;
                else
                    r=mid-1;
            }
            swap(nums,k,l);
            reverse(nums,k+1,n-1);
        }
    }

    void reverse(int[] arr,int start,int end){
        while (start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
