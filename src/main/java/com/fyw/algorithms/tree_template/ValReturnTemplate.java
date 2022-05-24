package com.fyw.algorithms.tree_template;

import com.fyw.algorithms.TreeNode;

/**
 * @Title ValReturnTemplate
 * @Author fyw
 * @Date 2022/5/8 1:19
 * @Description: 与返回值相关递归函数设计
 */
public class ValReturnTemplate {
    /**
     * 只要是涉及到 深度那么一般考虑后序遍历
     */
    static class Code104_110_111{
        // 后序遍历经典应用
        static class Code104{
            public int maxDepth(TreeNode root) {
                if (root==null)
                    return 0;
                int l=maxDepth(root.left);
                int r=maxDepth(root.right);
                return Math.max(l,r)+1;
            }
        }
        static class Code110{
            // 考虑一棵树里面所有节点的情况，那么一般有两种策略：
            // 1. 双重递归
            // 2. 维护全局变量
            public boolean isBalanced(TreeNode root) {
                if (root==null)
                    return true;
                int l=maxDepth(root.left);
                int r=maxDepth(root.right);
                return Math.abs(l-r)<2&&isBalanced(root.left)&&isBalanced(root.right);
            }
            public int maxDepth(TreeNode root) {
                if (root==null)
                    return 0;
                int l=maxDepth(root.left);
                int r=maxDepth(root.right);
                return Math.max(l,r)+1;
            }
        }
        static class Code111{
            public int minDepth(TreeNode root) {
                if (root==null)
                    return 0;
                if (root.left==null){
                    return minDepth(root.right)+1;
                }
                if (root.right==null){
                    return minDepth(root.left)+1;
                }
                int l=minDepth(root.left);
                int r=minDepth(root.right);
                return Math.min(l,r)+1;
            }
        }
    }

    static class Code543{
        /**
         * 1. 双重递归
         * 2. 维护全局变量
         * @param root
         * @return
         */
        int res=0;
        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return res;
        }
        int dfs(TreeNode root){
            if (root==null)
                return 0;
            int l=dfs(root.left);
            int r=dfs(root.right);
            res=Math.max(res,l+r);
            return Math.max(l,r)+1;
        }
    }

    static class Code129{
        public int sumNumbers(TreeNode root) {
            return dfs(root,0);
        }
        // 定义：返回从根节点到叶子结点的数字之和，
        // 技巧：在递归函数参数里面维护当前根节点到叶子结点的组成的数字
        int dfs(TreeNode root, int x){
            if (root==null)
                return 0;
            x=x*10+root.val;
            if (root.left==null&&root.right==null){
                return x;
            }
            int res=0;
            res+=dfs(root.left,x);
            res+=dfs(root.right,x);
            return res;
        }
    }
    static class Code1022{
        public int sumRootToLeaf(TreeNode root) {
            return dfs(root,0);
        }
        // 声明函数用于计算从根节点到叶的二进制数之和
        int dfs(TreeNode root,int x){
            if (root==null)
                return 0;
            int res=0;  // 记录二进制数之和
            x=x*2+x;
            if (root.left==null&&root.right==null){
                res+=x;
            }
            res+=dfs(root.left,x);
            res+=dfs(root.right,x);
            return res;
        }
    }


    static class Code404{
        public int sumOfLeftLeaves(TreeNode root) {
            return dfs(root);
        }
        int dfs(TreeNode root){
            if (root==null)
                return 0;
            int res=0;  // 记录左叶子之和
            if (root.left!=null&&root.left.right==null&&root.left.left==null){
                // 此时是左叶子，纳入到最后的结果中
                res+=root.left.val;
            }
            res+=dfs(root.left);
            res+=dfs(root.right);
            return res;
        }
    }
    static class Code124{

    }
    static class Code437{
        public int pathSum(TreeNode root, int targetSum) {
            if (root==null){
                return 0;
            }
            int res=dfs(root,targetSum);
            res+=pathSum(root.left,targetSum);
            res+=pathSum(root.right,targetSum);
            return res;
        }
        int dfs(TreeNode root,int targetSum){  /// 返回以root为节点时，结果的情况
            if (root==null){
                return 0;
            }
            targetSum-=root.val;
            int res=0;
            if (targetSum==0){
                res++;
            }
            res+=dfs(root.left,targetSum);
            res+=dfs(root.right,targetSum);
            return res;
        }
    }

    static class Code687{

    }



    static class Code938{

    }




}
