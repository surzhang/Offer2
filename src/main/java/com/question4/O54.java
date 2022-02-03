package com.question4;

import com.model.TreeNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName O54
 * @description :TODO 二叉搜索树的第k大节点
 * @date 2022/2/3 12:08
 */
public class O54 {
    /**
     * 中序遍历逆序
     */
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k=k;
        dfs(root);
        return res;
    }
    public void  dfs(TreeNode root){
        if (root==null)return;
        dfs(root.right);
        if (k==0)return;
        if (--k==0){
            res=root.val;
        }
        dfs(root.left);
    }
}
