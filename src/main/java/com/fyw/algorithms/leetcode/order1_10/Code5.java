package com.fyw.algorithms.leetcode.order1_10;

/**
 * @Title Code5
 * @Author fyw
 * @Date 2022/5/13 14:18
 * @Description:
 */
public class Code5 {
    /**
     * 回文：
     * 1. 马拉车算法：比较复杂同时很局限只能解决回文问题
     * 2. dp
     * 3. 枚举
     * 4. 字符串哈希
     */
    public String longestPalindrome(String s) {
        String ans="";
        for (int i = 0; i < s.length(); i++) {
            // 奇回文
            int l=i-1;
            int r=i+1;
            while (l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if (ans.length()<r-l-1){
                ans=s.substring(l+1,r);
            }
            // 偶回文
            l=i;
            r=i+1;
            while (l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if (ans.length()<r-l-1){
                ans=s.substring(l+1,r);
            }
        }
        return ans;
    }
}
