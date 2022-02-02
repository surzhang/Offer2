package com.question3;

import java.util.Stack;

/**
 * @author zyk
 * @version 1.0
 * @fileName O33
 * @description :TODO 二叉搜索树的后序遍历序列
 * @date 2022/2/2 16:00
 */
public class O33 {
    /**
     * 递归分治
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }


    //辅助单调栈(后序遍历逆序）
    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();

            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
