package com.wuying.algorithms.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * 相交链表，找到相交点
 */
public class Test04 {
    /**
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Intersected at '8'
     * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
     * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     * — 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。
     * 换句话说，它们在内存中指向两个不同的位置，
     * 而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
     */
    @Test
    public void test01() {
                   
    }

    /**
     * 方法一：双指针
     * 两个链表，都从头开始遍历。
     * 若两个链表相等长度，则当两个链表相等时即是交点
     * 若不相等，则链表1走到结尾时，令从链表2头开始重新遍历。
     * 链表2走到尾部时，令从链表1头不开始，当两个链表相等时即使交点
     * 
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * 从尾部开始遍历呢？，不对呀没法定位呀，怎么定位到尾部呢？
     * 先反转链表
     * 这样从新头开始遍历，当不相等时返回即可。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeMethod1(ListNode headA, ListNode headB) {
        // 先反转
        ListNode newHeadA = reverseLinkedList(headA);
        ListNode newHeadB = reverseLinkedList(headB);
        while (newHeadA != newHeadB) {
            newHeadA = newHeadA.next;
            newHeadB = newHeadB.next;
        }
        headA = newHeadA;
        return headA;
    }

    /**
     * 反转链表
      * @param head
     * @return
     */
    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
