package com.fyw.algorithms.hot100;

/**
 * @Title Code75
 * @Author fyw
 * @Date 2022/5/4 10:52
 * @Description:
 */
public class Code75 {
    public void sortColors(int[] nums) {
        int L=-1;
        int R=nums.length;
        int cur=0;
        while (cur<R){
            if (nums[cur]>1){
                swap(nums,cur,--R);
            }else if (nums[cur]<1){
                swap(nums,++L,cur++);
            }else{
                cur++;
            }
        }
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
