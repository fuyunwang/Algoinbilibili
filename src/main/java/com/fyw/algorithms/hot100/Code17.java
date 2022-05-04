package com.fyw.algorithms.hot100;

import java.util.*;

/**
 * @Title Code17
 * @Author fyw
 * @Date 2022/5/3 11:54
 * @Description:
 */
public class Code17 {
    /**
     *         Map<String,String> map=new HashMap<String,String>(){
     *             {
     *                 put("2","abc");
     *                 put("3","def");
     *                 put("4","ghi");
     *                 put("5","jkl");
     *                 put("6","mno");
     *                 put("7","pqrs");
     *                 put("8","tuv");
     *                 put("9","wxyz");
     *             }
     *         };
     */
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0){
            return Collections.emptyList();
        }
        Map<String, String> map = new HashMap<String, String>() {
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }
        };
        backtrack(digits,map,0,new StringBuilder());
        return res;
    }

    void backtrack(String digits,Map<String,String> map,int index,StringBuilder sb){
        if (index==digits.length()){
            res.add(new StringBuilder(sb).toString());
            return;
        }
        String cur=digits.substring(index,index+1);
        for (int i = 0; i < map.get(cur).length(); i++) {
            sb.append(map.get(cur).charAt(i));
            backtrack(digits,map,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
