package com.wuying.algorithms.onelevel;

import org.junit.jupiter.api.Test;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 
 * 并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */
public class Test02 {
    /**
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     */
    @Test
    public void test01() {
        
    }

    /**
     * 链表题
     * 首位对齐，不够补0，直接相加，大于10，则向后进1.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;// 表示进位
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;// 表示存放元素的值
            
            // 计算进位和余数
            carry = sum / 10;
            sum = sum % 10;
            
            // 存放
            cur.next = new ListNode(sum);
            cur = cur.next;
            // 移动指针
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // 如果最后进位是1，则补到最后面即可。
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
    
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { 
        this.val = val; this.next = next; 
    }
}
