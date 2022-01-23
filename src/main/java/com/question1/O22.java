package com.question1;

import com.model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName O22
 * @description :TODO 链表倒数第k个节点
 * @date 2022/1/23 12:42
 */
public class O22 {
    //双指针
    public ListNode getKthFromEnd(ListNode head,int k){
      ListNode former  =head,latter=head;
        for (int i = 0; i <k ; i++) {
            if (former==null)return null;
            former=former.next;
        }
        while (former!=null){
            former=former.next;
            latter=latter.next;
        }
        return latter;
    }
}
