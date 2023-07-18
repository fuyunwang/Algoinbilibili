package com.fyw.algorithms.hot100;

import com.fyw.algorithms.ListNode;

import java.util.PriorityQueue;

/**
 * @Title Code23
 * @Author fyw
 * @Date 2022/5/3 11:55
 * @Description:
 */
public class Code23 {
    /***
     * 多路归并：632/1090/373/264/313/719/786/1439/1508/1675
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue=new PriorityQueue<>((x,y)->x.val-y.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null){
                queue.offer(lists[i]);
            }
        }
        ListNode dummyHead=new ListNode(-1);
        ListNode cur=dummyHead;
        while (!queue.isEmpty()){
            ListNode top=queue.poll();
            ListNode node=new ListNode(top.val);
            cur.next=node;
            cur=cur.next;
            ListNode next=top.next;
            if (next!=null){
                queue.offer(next);
            }
        }
        return dummyHead.next;
    }
}
