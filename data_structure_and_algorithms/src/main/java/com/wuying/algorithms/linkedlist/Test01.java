package com.wuying.algorithms.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * 设计链表
 *
 * 设计链表的实现。您可以选择使用单链表或双链表。
 * 单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 *     get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 *     addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 *     addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 *     addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 *     deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 */
public class Test01 {
    
    @Test
    public void test01() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(3);
        System.out.println(myLinkedList.get(0));
        myLinkedList.deleteAtIndex(0);
    }
}
class MyLinkedList {
    int size;// 用来表示链表中的元素数量。
    
    ListNode head;
    
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        
        ListNode curr = head;
        
        for (int i = 0; i < index + 1;++i) curr = curr.next;
        
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /**
     * 创建一个值为val的节点并插入index前
     * 如果index为大于size，则直接return。
     * 若index为负数，则默认插入到头结点位置，也就是0前面。
     * 若在size范围内，则
     * 先令head赋值给新建的ListNode pred；
     * 新建一个ListNode并将其next赋值为pred.next;
     * 将新建的ListNode赋值给pred.next;
     * 
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index > size) return;

        if (index < 0) index = 0;
        
        // 到这里说明是正常范围内的，所以令size++
        ++size;
        
        ListNode pred = head;
        for (int i = 0; i < index; ++i) pred = pred.next;
        
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        
        size--;
        
        ListNode pred = head;

        for (int i = 0; i < index; ++i) pred = pred.next;
        
        // 令当前节点中存储的下一个节点中存储的下一个节点的引用给到当前节点的next。这样就删除了下一个节点（没有引用指向他）
        pred.next = pred.next.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode() {};
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}