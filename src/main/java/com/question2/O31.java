package com.question2;

import java.util.Stack;

/**
 * @author zyk
 * @version 1.0
 * @fileName O31
 * @description :TODO 栈的压入，弹出
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

 * @date 2022/2/1 17:05
 */
public class O31 {
    //双重循环
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>stack = new Stack<>();
        int i = 0;
        for (int num:pushed) {
            stack.push(num);
            while(!stack.isEmpty()&&stack.peek()==popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
