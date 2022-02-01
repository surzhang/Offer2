package com.question2;

import com.model.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @version 1.0
 * @fileName O35
 * @description :TODO 复杂链表的复制
 * @date 2022/2/1 15:23
 */
public class O35 {
    //hash表
    public Node copyRandomList(Node head) {
        if (head==null){
            return  null;
        }
        Node cur=head;
        Map<Node,Node> map = new HashMap<>();
        //复制各节点，并建立“原节点--》新节点”的map映射
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        //构建新链表的next和random指向
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur=cur.next;
        }
        //返回新链表的头结点
        return map.get(head);
    }
}
