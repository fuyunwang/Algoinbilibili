package com.fyw.algorithms.hot100;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Title Code76
 * @Author fyw
 * @Date 2022/5/4 10:52
 * @Description:
 */
public class Code76 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> window=new HashMap<>();
        HashMap<Character,Integer> need=new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
        int left=0,right=0;
        int valid=0;
        int start=0;
        int len=Integer.MAX_VALUE;
        while (right<s.length()){
            char cur=s.charAt(right);
            right++;
            if (need.containsKey(cur)){
                window.put(cur,window.getOrDefault(cur,0)+1);
                if (Objects.equals(window.get(cur),need.get(cur))){
                    valid++;
                }
            }
            while (valid==need.size()){
                if (len>right-left){
                    left=right-left;
                    start=left;
                }
                char lBorder=s.charAt(left);
                if (need.containsKey(lBorder)){
                    if (Objects.equals(need.get(lBorder),window.get(lBorder))){
                        valid--;
                    }
                    window.put(lBorder,window.getOrDefault(lBorder,0)-1);
                }
                left++;
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
