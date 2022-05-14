package com.fyw.algorithms.sort.quick;

import java.util.Arrays;

/**
 * @Title QuickSort
 * @Author fyw
 * @Date 2022/5/14 19:33
 * @Description:
 */
public class QuickSort2 {
    /**
     * 介绍快速排序的优化，随机三路快排。其中随机过程保证在数学期望的时间复杂度为O(nlogn)、三路保证每次确定一部分值的位置
     *
     * 首先来看三路快排的过程，也就是一次性确定一部分值的位置
     */
    public static void quickSort(int[] arr,int l,int r){
        if (l>=r){
            return;
        }
        // 首先随机选择一个元素，避免因为数组有序导致性能变差
        swap(arr,l+(int)(Math.random()*(r-l+1)),r);
        final int[] partition = partition(arr, l, r);
        quickSort(arr,l,partition[0]-1);
        quickSort(arr,partition[0]+1,r);
    }
    public static int[] partition(int[] arr,int L,int R){
        int less=L-1;
        int more=R;
        int cur=L;
        while (cur<more){
            if (arr[cur]<arr[R]){
                swap(arr,++less,cur++);
            }else if (arr[cur]>arr[R]){
                swap(arr,--more,cur);
            }else {
                cur++;
            }
        }
        swap(arr,more,R);
        return new int[]{less+1,more};
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        // 来测试一下
        int[] res=new int[100];
        for (int i = 0; i < res.length; i++) {
            res[i]= (int) (Math.random()*100+1);
        }
        System.out.println("未排序之前：");
        System.out.println(Arrays.toString(res));
        quickSort(res,0,res.length-1);
        System.out.println("排序之后");
        System.out.println(Arrays.toString(res));
    }
}
