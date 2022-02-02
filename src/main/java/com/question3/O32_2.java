package com.question3;

import com.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zyk
 * @version 1.0
 * @fileName O32_2
 * @description :TODO 二叉树层次遍历2
 * @date 2022/2/2 15:53
 */
public class O32_2 {
    public List<List<Integer>>levelOrder(TreeNode root){
        Queue<TreeNode>queue = new LinkedList<>();
        List<List<Integer>> res =new ArrayList<>();
        if (root!=null)queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer>tmp = new ArrayList<>();
            for (int i = queue.size(); i >0 ; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left!=null)queue.add(node.left);
                if (node.right!=null)queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
