package com.wuying.algorithms.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * 反转链表
 */
public class Test06 {
    @Test
    public void test01() {
        
    }
    public ListNode reverseLinkedNode(ListNode head) {
        if (head == null || head.next == null) return head;
        
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
