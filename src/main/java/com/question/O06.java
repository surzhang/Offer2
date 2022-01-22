package com.question;

import com.model.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyk
 * @version 1.0
 * @fileName O06
 * @description :TODO 从尾到头打印链表
 * @date 2022/1/22 16:00
 */
public class O06 {
    //用栈
    public int[] reversePrint(ListNode head) {
        Deque<ListNode>stack =new LinkedList<>();
        ListNode temp = head;
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        int size = stack.size();
        int []print = new int [size];
        for (int i = 0; i <size ; i++) {
            print[i]=stack.pop().val;
        }
        return print;
    }

    /**
     * 递推阶段： 每次传入 head.next ，以 head == null（即走过链表尾部节点）为递归终止条件，此时直接返回。
     * 回溯阶段： 层层回溯时，将当前节点值加入列表，即tmp.add(head.val)。
     * 最终，将列表 tmp 转化为数组 res ，并返回即可。
     * @param head
     * @return
     */
    ArrayList<Integer>tmp = new ArrayList<>();
    public int[]reversePrint2(ListNode head){
        recur(head);
        int[] res = new int [tmp.size()];
        for (int i = 0; i <res.length ; i++) {
            res[i]=tmp.get(i);
        }
        return res;
    }
    public void recur(ListNode head){
        if (head==null){
            return;
        }
        recur(head.next);
        tmp.add(head.val);
    }
}
