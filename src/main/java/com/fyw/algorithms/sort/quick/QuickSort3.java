package com.fyw.algorithms.sort.quick;

import com.fyw.algorithms.ListNode;

import java.util.List;

/**
 * @Title QuickSort3
 * @Author fyw
 * @Date 2022/5/14 19:40
 * @Description:
 */
public class QuickSort3 {
    /**
     * 链表快排
     * 链表快排其实相对比较简单，我们只需要在三路快排的思想上实现就可以
     * 具体说来我们维护三个子链表，
         * 其中1号链表代表小于某个值的所有节点、
         * 2号链表代表等于某个值的所有节点、
         * 3号链表代表大于某个值的所有节点
     */
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null)
            return head;    // 只有一个元素或者没有元素直接不用排序
        // 定义三个头结点分别指向1号、2号、3号链表方便操作
        ListNode left=new ListNode(-1);
        ListNode mid=new ListNode(-1);
        ListNode right=new ListNode(-1);
        // 定义尾指针方便操作
        ListNode ltail=left;
        ListNode rtail=right;
        ListNode mtail=mid;
        // 进行partition
        int val=head.val;
        for (ListNode cur=head;cur!=null;cur=cur.next){
            if (cur.val<val)
                ltail=ltail.next=cur;
            else if (cur.val>val)
                rtail=rtail.next=cur;
            else{
                mtail=mtail.next=cur;
            }
        }
        // 断开连接
        ltail.next=null;
        mtail.next=null;
        rtail.next=null;
        // 中间链表的位置已经确定不需要操作了，只需要递归左侧链表和右侧链表
        left.next=sortList(left.next);
        right.next=sortList(right.next);
        // 进行链表拼接，拼接的时候需要获取每个链表的尾结点指针
        getTail(left).next=mid.next;
        getTail(left).next=right.next;
        return left.next;
    }
    ListNode getTail(ListNode head){
        if (head.next!=null)
            head=head.next;
        return head;
    }

}
