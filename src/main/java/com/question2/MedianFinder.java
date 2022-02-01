package com.question2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zyk
 * @version 1.0
 * @fileName MedianFinder
 * @description :TODO
 * @date 2022/2/1 16:21
 */
public class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半，堆顶最小（从堆顶弹出元素）
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        //长度不相同先加入A
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    //查找中位数
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }

}
