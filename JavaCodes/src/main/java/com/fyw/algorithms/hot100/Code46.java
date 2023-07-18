package com.fyw.algorithms.hot100;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code46
 * @Author fyw
 * @Date 2022/5/3 11:56
 * @Description:
 */
public class Code46 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new LinkedList<>());
        return res;
    }
    void backtrack(int[] nums,LinkedList<Integer> path){
        if (path.size()==nums.length){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i]))
                continue;
            path.addLast(nums[i]);
            backtrack(nums,path);
            path.removeLast();
        }
    }
}
