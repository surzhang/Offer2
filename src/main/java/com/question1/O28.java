package com.question1;

import com.model.TreeNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName O28
 * @description :TODO 对称二叉树
 * @date 2022/1/23 11:06
 */
public class O28 {
    /**
     * 递归流程
     *isSymmetric(root) ：
     *
     * 特例处理： 若根节点 root 为空，则直接返回 true 。
     * 返回值： 即 recur(root.left, root.right) ;
     *recur(L, R) ：
     *
     * 终止条件：
     * 当 L 和 R 同时越过叶节点： 此树从顶至底的节点都对称，因此返回 true ；
     * 当 L 或 R 中只有一个越过叶节点： 此树不对称，因此返回 false ；
     * 当节点 L 值≠节点 R 值： 此树不对称，因此返回 false ；
     *
     * 递推工作：
     * 判断两节点 L.left和 R.right 是否对称，即 recur(L.left, R.right) ；
     * 判断两节点 L.right 和 R.left 是否对称，即 recur(L.right, R.left) ；
     *
     * 返回值： 两对节点都对称时，才是对称树，因此用与逻辑符 && 连接。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
      return root==null?true:recur(root.left,root.right);
    }
    private boolean recur(TreeNode left, TreeNode right) {
        if (left==null&&right==null){
            return true;
        }
        //结束条件
        if (left==null||right==null||left.val!=right.val){
            return false;
        }
//        递推工作和返回值
        return recur(left.left,right.right)&&recur(left.right,right.left);
    }
}
