package com.fyw.algorithms.hot100;

/**
 * @Title Code5
 * @Author fyw
 * @Date 2022/5/3 11:28
 * @Description:
 */
public class Code5 {
    public String longestPalindrome(String s) {
        String res="";

        for (int i = 0; i < s.length(); i++) {
            // 奇回文
            int left=i,right=i;
            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if (res.length()<right-left-1){
                res=s.substring(left+1,right);
            }
            // 偶回文
            left=i;
            right=i+1;
            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if (res.length()<right-left-1){
                res=s.substring(left+1,right);
            }
        }

        return res;
    }
}
