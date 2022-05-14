package com.fyw.algorithms.presum;

/**
 * @Title Difference
 * @Author fyw
 * @Date 2022/5/14 19:14
 * @Description: 经典的差分问题、差分乃是前缀和的逆向应用
 */
public class Difference {
    static class Code1094{
        // 统计类的题目一般用差分解决
        public boolean carPooling(int[][] trips, int capacity) {
            // 计算差分数组表示人数的变化
            int[] temp=new int[1001];   // 根据车站数定义数组
            for (int i=0;i<trips.length;i++){
                temp[trips[i][1]]+=trips[i][0]; // 当前车站上了这么多人
                temp[trips[i][2]]-=trips[i][0]; // 当前车站下了这么多人
            }
            // 计算前缀和，得到累计每个时刻的人数，判断是否超载
            int sum=0;
            for (int i = 0; i < temp.length; i++) {
                sum+=temp[i];
                if (sum>capacity)
                    return false;
            }
            return true;
        }
    }
    static class Code1109{
        public int[] corpFlightBookings(int[][] bookings, int n) {
            // n个航班且编号1到n
            int[] res=new int[n];
            // 注意索引错位
            // first到last属于预定的数量，那么也就是超过了last就会下飞机
            // 仍然是统计类型题目，进行差分统计变化，然后前缀和累计结果
            for (int i = 0; i < n; i++) {
                res[bookings[i][0]-1]+=bookings[i][2];
                if (bookings[i][1]<n){
                    res[bookings[i][1]]-=bookings[i][2];
                }
            }
            // 累计前缀和
            for (int i = 1; i < n; i++) {
                res[i]+=res[i-1];
            }
            return res;
        }
    }
}
