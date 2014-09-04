package PartitionList;

/**
 * Author: fangzhou
 * Date:   9/3/14.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode holder = new ListNode(-1);
        holder.next = head;
        ListNode small = holder, pre = holder, cur = head;
        while(cur != null) {
            ListNode curNext = cur.next;
            if(cur.val < x) {
                if(small.next != cur) {
                    pre.next = cur.next;
                    ListNode smallNext = small.next;
                    small.next = cur;
                    cur.next = smallNext;
                }
                small = small.next;
            }
            cur = curNext;
            while(pre.next != cur) {
                pre = pre.next;
            }
        }
        return holder.next;
    }
}
