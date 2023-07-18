package com.fyw.algorithms.sort.quick;

/**
 * @Title QuickSort5
 * @Author fyw
 * @Date 2022/5/14 19:40
 * @Description:
 */
public class QuickSort5 {
    /**
     * 解决颜色分类、荷兰国旗问题
     */
    public void sortColors(int[] nums) {
        int L=-1;
        int R=nums.length;
        int cur=0;
        while (cur<R){
            if (nums[cur]<1){
                swap(nums,++L,cur++);
            }else if(nums[cur]>1){
                swap(nums,cur,--R);
            }else{
                cur++;
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
