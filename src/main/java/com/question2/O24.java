package com.question2;

import com.model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName O24
 * @description :TODO 翻转链表
 * @date 2022/1/29 16:20
 */
public class O24 {
    //双指针
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
