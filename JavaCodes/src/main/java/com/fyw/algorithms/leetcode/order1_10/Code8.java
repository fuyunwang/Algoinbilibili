package com.fyw.algorithms.leetcode.order1_10;

/**
 * @Title Code8
 * @Author fyw
 * @Date 2022/5/13 14:41
 * @Description:
 */
public class Code8 {
    public int myAtoi(String s) {
        int index=0;    // 枚举s的每一个字符
        while (index<s.length()&&s.charAt(index)==' '){
            index++;
        }
        if (index==s.length())
            return 0;
        // 接下来记录正负号
        int flag=1;
        if (s.charAt(index)=='-'){
            flag=-1;
            index++;
        }else if (s.charAt(index)=='+'){
            index++;
        }
        int res=0;
        while (index<s.length()&&s.charAt(index)>='0'&&s.charAt(index)<='9'){
            int x=s.charAt(index)-'0';
            if (flag>0&&res>(Integer.MAX_VALUE-x)/10)
                return Integer.MAX_VALUE;
            if (flag<0&&-res<(Integer.MIN_VALUE+x)/10)
                return Integer.MIN_VALUE;
            if (-res*10-x==Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            res=res*10+x;
            index++;
        }
        res*=flag;
        return res;
    }
}
