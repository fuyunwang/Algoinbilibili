package com.fyw.algorithms.tree_template;

import com.fyw.algorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title SerialTemplate
 * @Author fyw
 * @Date 2022/5/8 1:16
 * @Description: 与序列化反序列化、基于遍历构造二叉树相关的题目
 */
public class SerialTemplate {
    static class Code105{
        Map<Integer,Integer> map=new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i= 0;  i< inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        }
        public TreeNode buildTree(int[] preorder,int[] inorder,int pl,int pr,int il,int ir){
            if (il>ir||pl>pr){
                return null;
            }
            int rootVal=preorder[pl];
            TreeNode root=new TreeNode(rootVal);
            int idx=map.get(rootVal);
            int num=idx-il;
            root.left=buildTree(preorder,inorder,pl+1,pl+num,il,idx-1);
            root.right=buildTree(preorder,inorder,pl+1+num,pr,idx+1,ir);
            return root;
        }
    }
    static class Code106{
        Map<Integer,Integer> map=new HashMap<>();
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return dfs(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
        }
        TreeNode dfs(int[] inorder,int[] postorder,int il,int ir,int pl,int pr){
            if (il>ir||pl>pr)
                return null;
            int rootVal=postorder[pr];
            TreeNode root=new TreeNode(rootVal);
            int idx=map.get(rootVal);
            int leftNum=idx-il;
            int rightNum=ir-idx;
            root.left=dfs(inorder,postorder,il,idx-1,pl,pl+leftNum-1);
            root.right=dfs(inorder,postorder,idx+1,ir,pl+leftNum,pl+leftNum+rightNum-1);
            return root;
        }
    }
    static class Code889{
        Map<Integer,Integer> map=new HashMap<>();
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            for (int i = 0; i < postorder.length; i++) {
                map.put(postorder[i],i);
            }
            return buildTree(preorder,postorder,0,preorder.length-1,0,postorder.length-1);
        }
        public TreeNode buildTree(int[] preorder,int[] postorder,int preL,int preR,int postL,int postR){
            if (preL>preR){
                return null;
            }
            int rootVal=preorder[preL];
            TreeNode root=new TreeNode(rootVal);
            if (preL==preR){
                return root;
            }
            int idx=map.get(preorder[preL+1]);
            int num=idx-postL;
            root.left=buildTree(preorder,postorder,preL+1,preL+1+num,postL,idx);
            root.right=buildTree(preorder,postorder,preL+1+num+1,preR,idx+1,postR-1);
            return root;
        }
    }



    static class Code297{

    }
    static class Code331{

    }

    static class Code971{   // 类似814题、331题、二叉树和二叉搜索树的序列化与反序列化

    }
    static class Code1028{

    }


    static class Code606{
        // 类似括号生成，也类似257、988

    }

    static class Code449{

    }

    static class Code652{

    }

    static class Code655{

    }

}
