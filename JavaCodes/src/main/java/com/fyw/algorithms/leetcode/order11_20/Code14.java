package com.fyw.algorithms.leetcode.order11_20;

/**
 * @Title Code14
 * @Author fyw
 * @Date 2022/5/13 20:46
 * @Description:
 */
public class Code14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null)
            return null;
        if (strs.length==1)
            return strs[0];
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c=strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i>=strs[j].length()||c!=strs[j].charAt(i))
                    return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
