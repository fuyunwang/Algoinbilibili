package com.fyw.algorithms.leetcode.order1_10;

import com.fyw.algorithms.ListNode;

/**
 * @Title Code2
 * @Author fyw
 * @Date 2022/5/13 13:55
 * @Description:
 */
public class Code2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead=new ListNode(-1);
        ListNode cur=dummyHead;
        int temp=0;
        while (l1!=null||l2!=null||temp!=0){
            int val1=l1==null?0:l1.val;
            int val2=l2==null?0:l2.val;
            temp+=val1;
            temp+=val2;
            ListNode node=new ListNode(temp%10);
            cur.next=node;
            temp/=10;
            if (l1!=null)
                l1=l1.next;
            if (l2!=null)
                l2=l2.next;
        }
        return dummyHead.next;
    }
}
