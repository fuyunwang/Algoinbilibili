package com.fyw.algorithms.sort.quick;

/**
 * @Title QuickSort6
 * @Author fyw
 * @Date 2022/5/14 19:40
 * @Description:
 */
public class QuickSort6 {
    /**
     * 解决数组奇偶排序问题
     * 考察的仍然是partition过程
     */
    public int[] sortArrayByParity(int[] nums) {
        int L=-1;
        int R=nums.length;
        int cur=0;
        while (cur<R){
            if (nums[cur]%2==0){
                // 偶数
                swap(nums,++L,cur++);
            }else{
                swap(nums,cur,--R);
            }
        }
        return nums;
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
