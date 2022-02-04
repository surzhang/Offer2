package com.question5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyk
 * @version 1.0
 * @fileName MaxQueue
 * @description :TODO 队列的最大值
 * @date 2022/2/4 10:40
 */
public class MaxQueue {
    //维护一个单调的双端队列
    /**
     * 从大到小的双端队列
     */
    Deque<Integer> d;
    /**
     * 辅助队列来记录所有被插入的值
     */
    Queue<Integer> q;

    public MaxQueue() {
        q = new LinkedList<>();
        d = new LinkedList<>();
    }

    //返回最大值
    public int max_value() {
        if (d.isEmpty()){
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value){
        while(!d.isEmpty()&&d.peekLast()<value){
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }
    public int pop_front(){
        if (q.isEmpty()){
            return -1;
        }
        int ans = q.poll();
        if (ans==d.peekFirst()){
            d.pollFirst();
        }
        return ans;
    }

}
