package com.fyw.algorithms.sort.quick;

import java.util.Arrays;

/**
 * @Title QuickSort1
 * @Author fyw
 * @Date 2022/5/14 19:33
 * @Description:
 */
public class QuickSort1 {
    /**
     * 首先介绍经典的快速排序，这里我们是从小到大排序
     */
    public static void quickSort(int[] arr,int l,int r){
        if (l>=r)   // 只有一个元素或者没有元素就不需要排序了
            return;
        int x=arr[l];   // 记录枢纽元素
        int i=l-1,j=r+1;
        while (i<j){
            while (arr[--j]>x);
            while (arr[++i]<x);
            if (i<j){
                // 找到了第一个不满足条件的元素
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        // 递归
        quickSort(arr,l,j);
        quickSort(arr,j+1,r);
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
