package com.fyw.algorithms.leetcode.order1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code1
 * @Author fyw
 * @Date 2022/5/13 13:47
 * @Description:
 */
public class Code1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
