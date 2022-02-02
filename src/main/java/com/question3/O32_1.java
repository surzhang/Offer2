package com.question3;

import com.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyk
 * @version 1.0
 * @fileName O32_1
 * @description :TODO 从上到下打印二叉树
 * @date 2022/2/2 15:47
 */
public class O32_1 {
//    BFS
    public int[] levelOrder(TreeNode root) {
        if (root==null)return new int [0];
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> ans=new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            ans.add(node.val);
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        int []res =new int [ans.size()];
        for (int i = 0; i <ans.size() ; i++) {
            res[i]=ans.get(i);
        }
        return res;
    }
}
