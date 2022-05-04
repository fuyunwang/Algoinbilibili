package com.fyw.algorithms.hot100;

import com.fyw.algorithms.ListNode;

/**
 * @Title Code21
 * @Author fyw
 * @Date 2022/5/3 11:55
 * @Description:
 */
public class Code21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead=new ListNode(-1);
        ListNode cur=dummyHead;
        ListNode cur1=list1;
        ListNode cur2=list2;
        while (cur1!=null&&cur2!=null){
            int val=cur1.val;
            if (val>cur2.val){
                val= cur2.val;
                cur2=cur2.next;
            }else{
                cur1=cur1.next;
            }
            ListNode node=new ListNode(val);
            cur.next=node;
            cur=cur.next;
        }
        while (cur1!=null){
            ListNode node=new ListNode(cur1.val);
            cur.next=node;
            cur=cur.next;
            cur1=cur1.next;
        }
        while (cur2!=null){
            ListNode node=new ListNode(cur2.val);
            cur.next=node;
            cur=cur.next;
            cur2=cur2.next;
        }
        return dummyHead.next;
    }
}
