package ReverseNodesinkGroup;

/**
 * Author: fangzhou
 * Date:   9/4/14.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1) {
            return head;
        }
        ListNode holder = new ListNode(-1);
        holder.next = head;
        ListNode pre = holder;
        int count = 0;
        while(head != null) {
            count++;
            if(count % k == 0) {
                pre = reverse(pre, head.next);    // return the last one in reverse order(the first one in original)
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return holder.next;
    }

    public ListNode reverse(ListNode pre, ListNode next) {
        ListNode first = pre.next;
        ListNode prev = pre, cur = pre.next;
        while(cur != next) {
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        pre.next = prev;
        first.next = next;
        return first;
    }
}
