package com.fyw.algorithms.leetcode.order51_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Title Code54
 * @Author fyw
 * @Date 2022/5/13 21:07
 * @Description:
 */
public class Code54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return Collections.emptyList();
        int m=matrix.length;
        int n=matrix[0].length;
        int[] dx=new int[]{0,1,0,-1};
        int[] dy=new int[]{1,0,-1,0};
        boolean[][] visited=new boolean[m][n];
        List<Integer> res=new ArrayList<>();
        for (int i = 0, x=0,y=0,d=0; i < m*n; i++) {
            res.add(matrix[x][y]);
            visited[x][y]=true;

            // 得到即将访问的点
            int a=x+dx[d];
            int b=y+dy[d];
            if (a<0||a>=m||b<0||b>=n||visited[a][b]){
                d=(d+1)%4;
                a=x+dx[d];
                b=y+dy[d];
            }
            x=a;
            y=b;
        }
        return res;
    }
}
