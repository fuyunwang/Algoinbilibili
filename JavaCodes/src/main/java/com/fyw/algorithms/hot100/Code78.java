package com.fyw.algorithms.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code78
 * @Author fyw
 * @Date 2022/5/4 10:52
 * @Description:
 */
public class Code78 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0,new LinkedList<>());
        return res;
    }
    void backtrack(int[] nums,int index,LinkedList<Integer> path){
        res.add(new LinkedList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums,i+1,path);
            path.removeLast();
        }
    }
}
