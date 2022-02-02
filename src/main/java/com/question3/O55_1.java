package com.question3;

import com.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zyk
 * @version 1.0
 * @fileName O55_1
 * @description :TODO 二叉树的深度
 * @date 2022/2/2 17:05
 */
public class O55_1 {
    //    DFS
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //    BFS
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            List<TreeNode> tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }


}
