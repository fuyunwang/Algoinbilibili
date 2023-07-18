package com.fyw.algorithms.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code3
 * @Author fyw
 * @Date 2022/5/3 11:27
 * @Description:
 */
public class Code3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> counts=new HashMap<>();
        int res=0;
        int left=0,right=0;
        for (;right<s.length();){
            char cur=s.charAt(right);
            counts.put(cur,counts.getOrDefault(cur,0)+1);
            while (counts.get(cur)>1){
                char leftOrder=s.charAt(left);
                counts.put(leftOrder,counts.getOrDefault(leftOrder,0)-1);
                left++;
            }
            res=Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}
