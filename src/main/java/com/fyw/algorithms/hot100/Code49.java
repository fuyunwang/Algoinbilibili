package com.fyw.algorithms.hot100;

import java.util.*;

/**
 * @Title Code49
 * @Author fyw
 * @Date 2022/5/3 11:56
 * @Description:
 */
public class Code49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr=strs[i].toCharArray();
            Arrays.sort(arr);
            String pattern=String.valueOf(arr);
            if (!map.containsKey(pattern)){
                map.put(pattern,new ArrayList<>());
            }
            map.get(pattern).add(strs[i]);
        }
        List<List<String>> res=new ArrayList<>();
        for (Map.Entry<String,List<String>> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
