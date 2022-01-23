package com.question1;

import com.model.TreeNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName O26
 * @description :TODO 树的子结构
 * @date 2022/1/23 10:47
 */
public class O26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    //比较两棵树是否相同
    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
