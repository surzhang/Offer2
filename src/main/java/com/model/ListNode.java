package com.model;

/**
 * @ fileName:ListNode
 * @ description:
 * @ author:zyk
 * @ createTime:2021/12/4 21:40
 * @ version:1.0.0
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
