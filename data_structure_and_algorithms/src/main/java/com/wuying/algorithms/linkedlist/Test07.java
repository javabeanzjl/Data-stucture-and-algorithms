package com.wuying.algorithms.linkedlist;

import org.junit.jupiter.api.Test;

    /**
     * 移除链表元素
     * 给你一个链表的头节点 head 和一个整数 val ，
     * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。 
     */
public class Test07 {
    /**
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     */
    @Test
    public void test01() {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        removeElements(listNode,5);
    }

    /**迭代
     * 分析
     * 遍历每一个节点，判断并删除，之后返回新链表
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode temp = newHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;    
            }
        }
        return newHead.next;
    }
    @Test
    public void test02() {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        removeElementsMethod(listNode,5);
    }

    /**
     * 用递归
     * 分析
     * 每次都是判断下一个节点的值是不是val
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsMethod(ListNode head,int val) {
        if (head == null) return head;
        
        head.next = removeElementsMethod(head.next, val);
        
        return head.val == val ? head.next : head;
    }
}
