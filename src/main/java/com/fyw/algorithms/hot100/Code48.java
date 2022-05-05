package com.fyw.algorithms.hot100;

/**
 * @Title Code48
 * @Author fyw
 * @Date 2022/5/3 11:56
 * @Description:
 */
public class Code48 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix,i,j,j,i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                swap(matrix,i,j,i,n-j-1);
            }
        }
    }
    public void swap(int[][] matrix,int i1,int j1,int i2,int j2){
        int temp=matrix[i1][j1];
        matrix[i1][j1]=matrix[i2][j2];
        matrix[i2][j2]=temp;
    }
}
