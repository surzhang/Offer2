package com.question2;

import com.model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName O18
 * @description :TODO  删除链表的节点
 * @date 2022/2/1 15:16
 */
public class O18 {
    //双指针
    public ListNode deleteNode(ListNode head, int val) {
       if (head.val==val)return head.next;
       ListNode pre = head,cur=head.next;
       //找到要删除节点跳出循环
       while(cur!=null&&cur.val!=val){
           pre=cur;
           cur=cur.next;
       }
       if (cur!=null){
           pre.next=cur.next;
       }
       return head;
    }
}
