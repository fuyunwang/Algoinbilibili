package com.fyw.algorithms.leetcode.order1_10;

import java.util.HashMap;

/**
 * @Title Code3
 * @Author fyw
 * @Date 2022/5/13 14:01
 * @Description:
 */
public class Code3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0,right=0;
        int res=0;
        while (right<s.length()){
            char c=s.charAt(right++);
            map.put(c,map.getOrDefault(c,0)+1);
            while (map.get(c)>1){
                char l=s.charAt(left++);
                map.put(l,map.getOrDefault(l,0)-1);
            }
            res=Math.max(res,right-left);
        }
        return res;
    }
}
