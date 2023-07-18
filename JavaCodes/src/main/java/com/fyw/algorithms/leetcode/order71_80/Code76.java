package com.fyw.algorithms.leetcode.order71_80;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Title Code76
 * @Author fyw
 * @Date 2022/5/14 18:46
 * @Description:
 */
public class Code76 {
    public String minWindow(String s, String t) {
        // 根据题意，要满足s涵盖t中所有字符。即字母异位词的思想，s只需要包含t中所有种类的字符并且相应数量一致即可
        Map<Character,Integer> need=new HashMap<>();// 统计t
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
        Map<Character,Integer> window=new HashMap<>();
        int left=0,right=0;
        int start=left;
        int len=Integer.MAX_VALUE;
        int valid=0;    // 统计已经数量对应满足的字符种类数
        while (right<s.length()){
            char rc=s.charAt(right++);
            if (need.containsKey(rc)){
                window.put(rc,window.getOrDefault(rc,0)+1);
                if (Objects.equals(window.get(rc),need.get(rc))){
                    valid++;
                }
            }
            while (valid==need.size()){ // 是一种s覆盖t的情况，需要滑动窗口探测更短的字符串
                // 更新结果
                if (len>right-left){
                    len=right-left;
                    start=left;
                }
                char lc=s.charAt(left++);
                if (need.containsKey(lc)){
                    if (Objects.equals(window.get(lc),need.get(lc))){
                        valid--;
                    }
                    window.put(lc,window.getOrDefault(lc,0)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
