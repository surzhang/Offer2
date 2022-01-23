package com.question1;

import com.model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName O25
 * @description :TODO 合并两个排序的链表
 * @date 2022/1/23 10:42
 */
public class O25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode cur = tmp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null) {
            tmp.next = l1;
        }
        if (l2 != null) {
            tmp.next = l2;
        }
        return cur.next;
    }
}
