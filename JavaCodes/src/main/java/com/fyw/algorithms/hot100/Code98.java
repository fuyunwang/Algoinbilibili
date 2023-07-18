package com.fyw.algorithms.hot100;

import com.fyw.algorithms.TreeNode;

/**
 * @Title Code98
 * @Author fyw
 * @Date 2022/5/4 11:10
 * @Description:
 */
public class Code98 {
    TreeNode pre=null;
    public boolean isValidBST(TreeNode root) {
        if (root==null)
            return true;
        boolean left=isValidBST(root.left);
        if (pre!=null&&pre.val>=root.val){
            return false;
        }
        pre=root;
        boolean right=isValidBST(root.right);
        return left&&right;
    }
}
