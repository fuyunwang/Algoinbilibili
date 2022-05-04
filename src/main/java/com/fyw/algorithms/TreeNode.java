package com.fyw.algorithms;

/**
 * @Title TreeNode
 * @Author fyw
 * @Date 2022/5/4 14:40
 * @Description:
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
