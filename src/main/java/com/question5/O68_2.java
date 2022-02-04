package com.question5;

import com.model.TreeNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName O68_2
 * @description :TODO 二叉树的最近公共祖先
 * @date 2022/2/4 16:55
 */
public class O68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||root==p||root==q){
            return root;
        }
        TreeNode left =lowestCommonAncestor(root.left,p,q);
        TreeNode right  = lowestCommonAncestor(root.right,p,q);
        if (left==null)return right;
        if (right==null)return left;
        return root;
    }
}
