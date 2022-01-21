package com.question;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyk
 * @version 1.0
 * @fileName O9
 * @description :TODO 用两个栈实现队列
 * @date 2022/1/21 21:27
 */
public class CQueue {
    //队列尾部
    Deque<Integer> stack1;
    //队列头部
    Deque<Integer> stack2;

    //初始化队列
    public CQueue(){
        stack1=new LinkedList<Integer>();
        stack2=new LinkedList<Integer>();
    }
    //尾部添加
    public void appendTail(int value){
        stack1.push(value);
    }
    //删除头
    public int deleteHead(){
        if (stack2.isEmpty()){
            while(!stack1.isEmpty()){
                //将尾部栈中元素放到头部栈中
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()){
            return -1;
        }else{
            //弹出头部元素
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }

}
