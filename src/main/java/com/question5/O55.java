package com.question5;

import com.model.TreeNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName O55
 * @description :TODO 平衡二叉树2
 * @date 2022/2/4 15:33
 */
public class O55 {
    //自顶向下的递归
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }else{
            return Math.abs(height(root.left)-height(root.right))<=1&&isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int height(TreeNode root) {
        if (root==null){
            return 0;
        }else{
            return Math.max(height(root.left),height(root.right))+1;
        }
    }

    /**
     *自下向上的递归
     */
    public boolean isBalanced2(TreeNode root) {
        return height2(root) >= 0;
    }

    private int height2(TreeNode root) {
        if (root==null){
            return 0;
        }
        int lh = height2(root.left);
        int rh = height2(root.right);
        if (lh==-1||rh==-1||Math.abs(lh-rh)>1){
            return -1;
        }else{
            return Math.max(lh,rh)+1;
        }
    }


}
