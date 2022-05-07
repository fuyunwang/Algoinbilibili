package com.fyw.algorithms.hot100;

import com.fyw.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Title Code94
 * @Author fyw
 * @Date 2022/5/4 11:10
 * @Description:
 */
public class Code94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (!stack.isEmpty()||cur!=null){
            if (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                TreeNode top=stack.pop();
                res.add(top.val);
                cur=top.right;
            }
        }
        return res;
    }
}
