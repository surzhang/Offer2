package com.question3;

import com.model.TreeNode;

import java.util.*;

/**
 * @author zyk
 * @version 1.0
 * @fileName O34
 * @description :TODO 二叉树中和为某一值的路径，给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径
 * @date 2022/2/2 17:04
 */
public class O34 {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();


    //深度优先搜索
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ret;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        //此处用作栈，尾部加入
        path.offerLast(root.val);
        target -= root.val;
        //到达叶节点并且完成任务
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        //尾部弹出
        path.pollLast();
    }

    //BFS
    Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
    public List<List<Integer>> pathSum2(TreeNode root, int target) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == target) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret;
    }

    public void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<Integer>(temp));
    }

}
