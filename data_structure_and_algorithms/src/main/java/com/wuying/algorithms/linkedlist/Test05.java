package com.wuying.algorithms.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * 删除链表倒数第n个节点
 */
public class Test05 {

    /**
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     */
    @Test
    public void test01() {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        removeNthFromEnd(listNode,3);
    }

    /**
     * 分析
     * 删除倒数第n个节点就是删除正数第size - n + 1个节点。
     * 所以先遍历链表得出size
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 计算size
        int size = getLinkedListSize(head);
        ListNode dumy = new ListNode(0, head);
        ListNode curr = dumy;
        // 删除节点
        int target = size - n + 1;
        for (int i = 1; i < target; ++i) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        ListNode ans = dumy.next;
        return ans;
    }
    public int getLinkedListSize(ListNode head) {
        int size = 0;
        while (head != null) {
            ++size;
            head = head.next;
        }
        return size;
    }

    /**
     * 利用双指针
     * 先遍历一个指针first，遍历n次
     * 另一个指针接着遍历，当first指针遍历到头时，second的下一个节点就是要删除的指针，因为两者相差n-1个节点。
     *
     */
    public ListNode removeNthFromEndMethod(ListNode head, int n) {
        ListNode dumy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dumy;
        int count = 0;
        // 先遍历两次
        while (count++ < n) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 此时second的下一个节点就是要删除的节点
        second.next = second.next.next;
        ListNode ans = dumy.next;
        return ans;
    }
}
