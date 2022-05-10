package com.fyw.algorithms.tree_template;

import com.fyw.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                if (root==null){
                    return;
                }
                if (root.val<min){
                    less=min;
                    min=root.val;
                }else if(root.val>min&&root.val<less){
                    less=root.val;
                }
                dfs(root.left);
                dfs(root.right);
            }
        }
        static class Code951{
            public boolean flipEquiv(TreeNode root1, TreeNode root2) {
                if (root1==null&&root2==null)
                    return true;
                if (root1==null||root2==null)
                    return false;
                if (root1.val!= root2.val)
                    return false;
                return flipEquiv(root1.left,root2.left)&&flipEquiv(root1.right,root2.right)
                        ||flipEquiv(root1.right,root2.left)&&flipEquiv(root1.left,root2.right);
            }
        }
        static class Code965{
            int initVal;
            boolean flag=true;
            public boolean isUnivalTree(TreeNode root) {
                if (root==null)
                    return true;
                initVal=root.val;
                dfs(root);
                return flag;
            }
            void dfs(TreeNode root){
                if (root==null)
                    return;
                if (root.val!=initVal){
                    flag=false;
                    return;
                }
                dfs(root.left);
                dfs(root.right);
            }
        }
    }


    // LCA、子树，此类问题采用后序遍历
    static class Code235_236{
        static class Code235{
            public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                if (root==null)
                    return null;
                if (p==root||q==root)
                    return root;
                if (p.val>q.val){
                    TreeNode temp=p;
                    p=q;
                    q=temp;
                }
                if (p.val<=root.val&&q.val>=root.val){
                    return root;
                }
                if (q.val<root.val)
                    return lowestCommonAncestor(root.left,p,q);
                return lowestCommonAncestor(root.right,p,q);
            }
        }
        static class Code236{
            public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                if (root==null)
                    return null;
                if (p==root||q==root)
                    return root;
                TreeNode left=lowestCommonAncestor(root.left,p,q);
                TreeNode right=lowestCommonAncestor(root.right,p,q);
                if (left==null&&right==null)
                    return null;
                if (left!=null&&right!=null)
                    return root;
                return left==null?right:left;
            }
        }
    }
    static class Code814{
        public TreeNode pruneTree(TreeNode root) {
            if (!dfs(root)){
                root=null;
            }
            return root;
        }
        // 声明函数，实现了判断从当前根节点开始它的子树是不是含有1，返回判断结果，同时在过程之中进行剪枝
        boolean dfs(TreeNode root){
            if (root==null)
                return false;
            if (!dfs(root.left))
                root.left=null;
            if (!dfs(root.right))
                root.right=null;
            return root.val==1||dfs(root.left)||dfs(root.right);
        }
    }
    static class Code865{
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return dfs(root);
        }
        int getDepth(TreeNode root){
            if (root==null)
                return 0;
            int l=getDepth(root.left);
            int r=getDepth(root.right);
            return Math.max(l,r)+1;
        }
        TreeNode dfs(TreeNode root){
            if (root==null)
                return null;
            int l=getDepth(root.left);
            int r=getDepth(root.right);
            if (l==r)
                return root;
            if (l<r)
                return dfs(root.right);
            return dfs(root.left);
        }

    }
    static class Code1080{
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            if (root==null)
                return null;
            limit-=root.val;
            if (root.left==null&&root.right==null){
                if (limit>0)
                    root=null;
            }else{
                root.left=sufficientSubset(root.left,limit);
                root.right=sufficientSubset(root.right,limit);
                if (root.left==null&&root.right==null)
                    root=null;
            }
            return root;
        }

    }
    static class Code1110{
        Set<Integer> set=new HashSet<>();
        List<TreeNode> res=new ArrayList<>();
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            for (int i:to_delete){
                set.add(i);
            }
            dfs(root,null);
            if (!set.contains(root.val)){
                res.add(root);
            }
            return res;
        }
        void dfs(TreeNode root,TreeNode parent){
            if (root==null)
                return;
            dfs(root.left,root);
            dfs(root.right,root);
            if (set.contains(root.val)){
                if (parent!=null&&parent.left==root)
                    parent.left=null;
                if (parent!=null&&parent.right==root)
                    parent.right=null;
                if (root.left!=null)
                    res.add(root.left);
                if (root.right!=null)
                    res.add(root.right);
            }
        }
    }



    // 含叶子结点
    static class Code112_113{

    }
    static class Code257{

    }
    static class Code988{

    }
    static class Code971{   // 类似814题、331题、二叉树和二叉搜索树的序列化与反序列化

    }
    static class Code331{

    }

    // 覆盖思想
    static class Code199_513_872{
        static class Code513{

        }
        static class Code199{

        }
        static class Code872{

        }
    }

    // 返回二维结果
    static class Code979{
        // 类似993
    }
    static class Code993{
        // 二叉树堂兄弟节点
    }


    // 双重递归，实现所有节点结果情况的考虑，类似572
    static class Code863{

    }
}
