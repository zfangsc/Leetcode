package RotateList;

/**
 * Author: fangzhou
 * Date:   8/29/14.
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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || n == 0) {
            return head;
        }
        int len = 1;
        ListNode cur = head;
        while(cur.next != null) {
            len++;
            cur = cur.next;
        }
        cur.next = head;
        int firstLen = len - n%len;
        cur = head;
        ListNode pre = null;
        for(int i = 0; i < firstLen; i++) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        return cur;
    }
}
