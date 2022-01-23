package com.question1;

import com.model.TreeNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName O27
 * @description :TODO 二叉树的镜像
 * @date 2022/1/23 11:00
 */
public class O27 {
    public TreeNode mirrorTree(TreeNode root) {
       if (root==null){
           return null;
       }
       TreeNode left = mirrorTree(root.left);
       TreeNode right = mirrorTree(root.right);
       root.left=right;
       root.right=left;
       return root;
    }
}
