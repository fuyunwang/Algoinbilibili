package com.fyw.algorithms.leetcode.order1_10;

/**
 * @Title Code6
 * @Author fyw
 * @Date 2022/5/13 14:28
 * @Description:
 */
public class Code6 {
    public String convert(String s, int numRows) {
        if (numRows==1)
            return s;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i==0||i==numRows-1){
                for (int j = i; j < s.length(); j+=(2*numRows-2)) {
                    sb.append(s.charAt(j));
                }
            }else{
                for (int j = i,k=2*numRows-2-i; j <s.length()||k<s.length() ; j+=(2*numRows-2),k+=(2*numRows-2)) {
                    if (j<s.length())
                        sb.append(s.charAt(j));
                    if (k<s.length())
                        sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();
    }
}
