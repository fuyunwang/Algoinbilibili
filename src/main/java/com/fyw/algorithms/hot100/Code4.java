package com.fyw.algorithms.hot100;

/**
 * @Title Code4
 * @Author fyw
 * @Date 2022/5/3 11:27
 * @Description:
 */
public class Code4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        return (getK(nums1,0,m-1,nums2,0,n-1,(m+n+1)/2)
                +
                getK(nums1,0,m-1,nums2,0,n-1,(m+n+2)/2))*0.5;
    }
    int getK(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        int len1=end1-start1+1;
        int len2=end2-start2+1;
        if (len1>len2)
            return getK(nums2,start2,end2,nums1,start1,end1,k);
        // 考虑边界条件
        // 基于比较短的数组以及k考虑两个边界条件
        if (start1==len1){
            return nums2[start2+k-1];
        }
        if (k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        int index1=start1+Math.min((k/2),len1)-1;
        int index2=start2+Math.min((k/2),len2)-1;
        if (nums1[index1]>nums2[index2]){
            return getK(nums1,start1,end1,nums2,index2+1,end2,k-(index2-start2+1));
        }else{
            return getK(nums1,index1+1,end1,nums2,start2,end2,k-(index1-start1+1));
        }
    }
}
