package com.fyw.algorithms.leetcode.order560_570;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Title Code567
 * @Author fyw
 * @Date 2022/5/14 19:05
 * @Description:
 */
public class Code567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need=new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i),need.getOrDefault(s1.charAt(i),0)+1);
        }
        Map<Character,Integer> window=new HashMap<>();
        int left=0,right=0;
        int valid=0;
        while (right<s2.length()){
            char rc=s2.charAt(right++);
            window.put(rc,window.getOrDefault(rc,0)+1);
            if (Objects.equals(window.get(rc),need.get(rc))){
                valid++;
            }
            while (right-left>=s1.length()){
                if (valid==need.size())
                    return true;
                char lc=s2.charAt(left++);
                if (Objects.equals(window.get(lc),need.get(lc))){
                    valid--;
                }
                window.put(lc,window.getOrDefault(lc,0)-1);
            }
        }
        return false;
    }

}
