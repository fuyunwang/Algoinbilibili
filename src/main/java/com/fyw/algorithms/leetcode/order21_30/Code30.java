package com.fyw.algorithms.leetcode.order21_30;

import java.util.*;

/**
 * @Title Code30
 * @Author fyw
 * @Date 2022/5/13 22:10
 * @Description:
 */
public class Code30 {
    public List<Integer> findSubstring(String s, String[] words) {
        // 首先进行边界判断
        if (s==null||words==null)
            return Collections.emptyList();
        List<Integer> res=new ArrayList<>();// 结果集合
        // 题目要求找到的子串由words中所有单词拼接得到，但是不考虑顺序
        // 也就是说我们要满足种类和频次都要对应，拼接得到的字符串即所求
        // 所以我们要借助 字母异位词分组 题目的思路，记录所有单词的频次，然后依次匹配频次
        Map<String,Integer> freq=new HashMap<>();// 原始频次记录
        // 频次需要记录
        for (int i = 0; i < words.length; i++) {
            freq.put(words[i],freq.getOrDefault(words[i],0)+1);
        }
        Map<String,Integer> map=new HashMap<>(); // 匹配过程中的频次记录
        // 题目要求单词长度都相同并且中间不会出现其他字符
        // 这也就给我们了可以枚举的索引范围
        // 最后一个位置必须要在 s.length() - n*len 之前，这里n=words.length len=words[0].length()
        int len=words[0].length();
        int n=words.length;
        // 枚举所有可能的开始索引
        for (int i = 0; i <= s.length()-n*len; i++) {
            // 枚举所有可能的单词，注意这里存在多个结果，所以每次map都必须是最新的，不能受到之前方案的影响
            map.clear();
            int j=0;// 枚举可能的单词
            while (j<n){
                String cur=s.substring(i+j*len,i+j*len+len);
                if (!freq.containsKey(cur)){
                    // 如果不包含，那么提前截止
                    break;
                }else{
                    // 包含的话频次进行记录并比较，超过了频次也需截止
                    map.put(cur,map.getOrDefault(cur,0)+1);
                    if (map.get(cur)>freq.get(cur))
                        break;
                }
                j++;
            }
            // 在这里需要判断是不是成功匹配了一个方案
            if (j==n)
                res.add(i);
        }
        return res;
    }
}
