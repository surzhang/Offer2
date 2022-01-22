package com.model;

/**
 * @FileName: TreeNode
 * @Description:
 * @Author: zyk
 * @createTime: 2021/12/19 11:28
 * @version: 1.0
 */

//定义一棵树
public class TreeNode {
   public int val;
   public TreeNode left;
   public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
