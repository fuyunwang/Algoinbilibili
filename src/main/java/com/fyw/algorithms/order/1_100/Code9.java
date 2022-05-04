package com.fyw.algorithms.order;

/**
 * @Title Code9
 * @Author fyw
 * @Date 2022/1/18 14:39
 * @Description: 回文数
 */
public class Code9 {
    public boolean isPalindrome(int x) {
        int temp=x;
        long result=0;
        while (x!=0){
            result = result * 10 + x%10;
            x/=10;
        }
        return temp >= 0 && result == temp;
    }
}
