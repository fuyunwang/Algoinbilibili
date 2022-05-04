package com.fyw.algorithms.hot100;


import com.fyw.algorithms.ListNode;

/**
 * @Title Code2
 * @Author fyw
 * @Date 2022/5/3 11:27
 * @Description:
 */
public class Code2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead=new ListNode(-1);

        ListNode cur=dummyHead;
        ListNode cur1=l1;
        ListNode cur2=l2;
        int temp=0; // 进位
        while (cur1!=null||cur2!=null||temp!=0){
            int val1=cur1==null?0:cur1.val;
            int val2=cur2==null?0:cur2.val;
            temp=temp+val1+val2;
            ListNode node=new ListNode(temp%10);
            temp/=10;
            cur.next=node;
            cur=cur.next;
            if (cur1!=null)
                cur1=cur1.next;
            if (cur2!=null)
                cur2=cur2.next;
        }
        return dummyHead.next;
    }
}
