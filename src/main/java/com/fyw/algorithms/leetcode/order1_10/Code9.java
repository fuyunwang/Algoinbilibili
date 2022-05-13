package com.fyw.algorithms.leetcode.order1_10;

/**
 * @Title Code9
 * @Author fyw
 * @Date 2022/5/13 15:02
 * @Description:
 */
public class Code9 {
    public boolean isPalindrome(int x) {
        if (x<0)
            return false;
        int temp=x;
        int res=0;
        while (x!=0){
            res=res*10+x%10;
            x/=10;
        }
        return res==temp;
    }
}
