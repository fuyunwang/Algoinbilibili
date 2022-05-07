package com.fyw.algorithms.hot100;

import com.fyw.algorithms.TreeNode;

/**
 * @Title Code104
 * @Author fyw
 * @Date 2022/5/4 11:40
 * @Description:
 */
public class Code104 {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int l=maxDepth(root.left);
        int r=maxDepth(root.right);
        return Math.max(l,r)+1;
    }
}
