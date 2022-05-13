package com.fyw.algorithms.leetcode.order1_10;

/**
 * @Title Code7
 * @Author fyw
 * @Date 2022/5/13 14:33
 * @Description:
 */
public class Code7 {
    public int reverse(int x) {
        int res=0;
        while (x!=0){
            if (res>0&&res>(Integer.MAX_VALUE-x%10)/10)
                return 0;
            if (res<0&&res<(Integer.MIN_VALUE-x%10)/10)
                return 0;
            res=res*10+x%10;
            x/=10;
        }
        return res;
    }
}
