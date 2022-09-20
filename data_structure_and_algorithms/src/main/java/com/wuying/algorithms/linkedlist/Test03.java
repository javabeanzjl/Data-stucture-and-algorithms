package com.wuying.algorithms.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * 环形链表 II
 *
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 */
public class Test03 {
    /**
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     */
    @Test
    public void test01() {
        
    }

    /**
     * 假设起始位置是a在b处是循环点，c处是相遇点.
     * 令ab = x；bc = y，cb = z；
     * 快慢指针
     * 假设第一次相遇，循环了n圈
     * 快指针 = 慢指针 * 2
     * x + n(y + z) + y = x + 2 * (x + y)
     * x = (n - 1) (y + z) + z
     * 这里的n一定是大于等于1的，因为快指针不可能在第一圈与慢指针相遇。
     * n = 1时，x = z；循环一圈相遇
     * x是头到环入口距离
     * z是相遇点到入口距离
     * 这意味着从头结点出发一个指针和从相遇点出发一个同样速率的指针，他们相遇的位置就是环入口。
     * 
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针同时出发，相遇即使入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
