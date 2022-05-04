package com.fyw.algorithms.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code1
 * @Author fyw
 * @Date 2022/5/3 11:27
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
