package com.fyw.algorithms.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title Code56
 * @Author fyw
 * @Date 2022/5/4 10:51
 * @Description:
 */
public class Code56 {
    public int[][] merge(int[][] intervals) {
        if (intervals==null||intervals.length<1||intervals[0].length<1)
            return new int[0][0];
        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0]>end){
                list.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }else{
                end=Math.max(end,intervals[i][1]);
            }
        }
        list.add(new int[]{start,end});
        int[][] res=new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0]=list.get(i)[0];
            res[i][1]=list.get(i)[1];
        }
        return res;
    }
}
