package com.fyw.algorithms.hot100;

import com.fyw.algorithms.ListNode;

/**
 * @Title Code19
 * @Author fyw
 * @Date 2022/5/3 11:54
 * @Description:
 */
public class Code19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        // 让快指针来到正数第n个位置
        for (int i = 0; i < n-1; i++) {
            fast=fast.next;
        }
        // 同时让快指针和慢指针移动并且记录慢指针的prev
        while (fast!=null&&fast.next!=null){
            prev=slow;
            fast=fast.next;
            slow=slow.next;
        }
        // 进行边界的特判
        if (fast==head){
            return null;
        }
        if (slow==head){
            return slow.next;
        }
        if (prev!=null){
            prev.next=slow.next;
        }
        return head;
    }
}
