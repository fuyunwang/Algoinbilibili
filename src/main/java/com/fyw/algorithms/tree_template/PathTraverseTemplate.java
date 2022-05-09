package com.fyw.algorithms.tree_template;

import com.fyw.algorithms.TreeNode;

/**
 * @Title PathTraverseTemplate
 * @Author fyw
 * @Date 2022/5/8 1:19
 * @Description: 路径遍历类题目、含叶子结点的题目
 */
public class PathTraverseTemplate {
    static class Code100_101_572_617_654_671_951_965{
        // 简单题
        static class Code100{
            public boolean isSameTree(TreeNode p, TreeNode q) {
                if (p==null&&q==null){
                    return true;
                }
                if (p==null||q==null){
                    return false;
                }
                return p.val==q.val&&isSameTree(p.left,q.left)
                        &&isSameTree(p.right,q.right);
            }
        }
        static class Code101{
            public boolean isSymmetric(TreeNode root) {
                return dfs(root,root);
            }
            boolean dfs(TreeNode p,TreeNode q){
                if (p==null&&q==null){
                    return true;
                }
                if (p==null||q==null){
                    return false;
                }
                return p.val==q.val&&dfs(p.left,q.right)
                        &&dfs(p.right,q.left);
            }
        }
        static class Code572{
            public boolean isSubtree(TreeNode root, TreeNode subRoot) {
                if (root==null)
                    return false;
                return isSameTree(root,subRoot)
                        ||isSubtree(root.left, subRoot)
                        ||isSubtree(root.right,subRoot);
            }
            public boolean isSameTree(TreeNode p, TreeNode q) {
                if (p==null&&q==null){
                    return true;
                }
                if (p==null||q==null){
                    return false;
                }
                return p.val==q.val&&isSameTree(p.left,q.left)
                        &&isSameTree(p.right,q.right);
            }
        }
        static class Code617{
            public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
                if (root1==null)
                    return root2;
                if (root2==null)
                    return root1;
                root1.val+=root2.val;
                root1.left=mergeTrees(root1.left,root2.left);
                root1.right=mergeTrees(root1.right,root2.right);
                return root1;
            }
        }
        static class Code654{
            public TreeNode constructMaximumBinaryTree(int[] nums) {
                return dfs(nums,0,nums.length-1);
            }
            TreeNode dfs(int[] nums,int l,int r){
                if (l>r){
                    return null;
                }
                int max=nums[l];
                int idx=l;
                for (int i = l; i <= r; i++) {
                    if (max<nums[i]){
                        max=nums[i];
                        idx=i;
                    }
                }
                TreeNode root=new TreeNode(max);
                root.left=dfs(nums,l,idx-1);
                root.right=dfs(nums,idx+1,r);
                return root;
            }
        }
        static class Code671{
            long min=Long.MAX_VALUE,less=min;
            public int findSecondMinimumValue(TreeNode root) {
                dfs(root);
                return less==Long.MAX_VALUE?-1: (int) less;
            }
            void dfs(TreeNode root){
                if (root==null)
                    return;
                if (min<root.val){
                    less=min;
                    min=root.val;
                }else if (root.val<less&&root.val>min){
                    less=root.val;
                }
                dfs(root.left);
                dfs(root.right);
            }
        }
    }


    // LCA、子树，此类问题采用后序遍历
    static class Code235_236{

    }
    static class Code814{

    }
    static class Code865{

    }
    static class Code1080{

    }
    static class Code1110{

    }



    // 含叶子结点
    static class Code112_113{

    }
    static class Code257{

    }
    static class Code988{

    }
    static class Code971{

    }

    static class Code199_513_872{
        static class Code513{

        }
        static class Code199{

        }
        static class Code872{

        }
    }

    static class Code979{
        // 类似993
    }
    static class Code993{
        // 二叉树堂兄弟节点
    }


    // 双重递归

    static class Code863{

    }

}
