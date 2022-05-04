package com.fyw.algorithms.hot100;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code39
 * @Author fyw
 * @Date 2022/5/3 11:55
 * @Description:
 */
public class Code39 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,0,target,new LinkedList<>());
        return res;
    }
    void backtrack(int[] candidates,int index,int target,LinkedList<Integer> path){
        if (index==candidates.length){
            if (target==0){
                res.add(new LinkedList<>(path));
                return;
            }else{
                return;
            }
        }
        for (int i = 0; i*candidates[index] <= target; i++) {    // 枚举每一个元素的可选次数
            backtrack(candidates,index+1,target-i*candidates[index],path);
            path.addLast(candidates[index]);
        }
        for (int i = 0; i*candidates[index] <= target; i++) {
            path.removeLast();

        }
        }
}
