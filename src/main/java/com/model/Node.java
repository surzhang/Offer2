package com.model;

/**
 * @author zyk
 * @version 1.0
 * @fileName Node
 * @description :TODO
 * @date 2022/2/1 15:25
 */
public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}
