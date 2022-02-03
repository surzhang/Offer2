package com.question4;

import com.model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName O52
 * @description :TODO 两个链表的第一个公共节点
 * @date 2022/2/3 10:14
 */
public class O52 {
    //双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }
}
