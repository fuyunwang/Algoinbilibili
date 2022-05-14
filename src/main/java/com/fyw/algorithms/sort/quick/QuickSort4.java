package com.fyw.algorithms.sort.quick;

/**
 * @Title QuickSort4
 * @Author fyw
 * @Date 2022/5/14 19:40
 * @Description:
 */
public class QuickSort4 {
    /**
     * 解决找数组中第K大元素的问题
     * 只需要基于快速排序找元素即可
     * 注意第K大元素需要从大到小排列并且找到索引为k-1的元素
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,k-1);
    }
    public int quickSort(int[] arr,int l,int r,int k){
        if (l>=r)
            return arr[l];
        int x=arr[l];
        int i=l-1,j=r+1;
        while (i<j){
            while (arr[++i]>x);
            while (arr[--j]<x);
            if (i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        if (k<=j)
            return quickSort(arr,l,j,k);
        else
            return quickSort(arr,j+1,r,k);
    }
}
