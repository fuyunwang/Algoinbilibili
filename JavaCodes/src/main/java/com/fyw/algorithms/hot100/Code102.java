package com.fyw.algorithms.hot100;

import com.fyw.algorithms.TreeNode;

import java.util.*;

/**
 * @Title Code102
 * @Author fyw
 * @Date 2022/5/4 11:40
 * @Description:
 */
public class Code102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
            return Collections.emptyList();
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode top=queue.poll();
                list.add(top.val);
                TreeNode left=top.left;
                TreeNode right=top.right;
                if (left!=null){
                    queue.offer(left);
                }
                if (right!=null){
                    queue.offer(right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
