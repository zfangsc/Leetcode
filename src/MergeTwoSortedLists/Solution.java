package MergeTwoSortedLists;

/**
 * Author: fangzhou
 * Date:   8/26/14.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode cur1 = l1, cur2 = l2, result = new ListNode(-1), cur = result; // dummy header
        while(cur1 != null || cur2 != null) {
            if(cur1 == null) {
                cur.next = cur2;
                cur2 = cur2.next;
            } else if(cur2 == null) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                if(cur1.val < cur2.val) {
                    cur.next = cur1;
                    cur1 = cur1.next;
                } else {
                    cur.next = cur2;
                    cur2 = cur2.next;
                }
            }
            cur = cur.next;
        }
        cur.next = null;

        return result.next;
    }
}
