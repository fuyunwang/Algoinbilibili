package com.fyw.algorithms.order.order1_100;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

/**
 * @Title Code2
 * @Author fyw
 * @Date 2022/1/20 19:53
 * @Description: 两数相加
 */
public class Code2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        ListNode cur=head;
        int temp=0;
        while (l1!=null||l2!=null||temp!=0){
            int val1=l1==null?0: l1.val;
            int val2=l2==null?0: l2.val;
            int sum = val1 + val2 + temp;
            ListNode node=new ListNode(sum%10);
            temp = sum/10;
            cur.next=node;
            cur=cur.next;
            if (l1!=null)
                l1=l1.next;
            if (l2!=null)
                l2=l2.next;
        }
        return head.next;
    }
}
