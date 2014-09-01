package InsertionSortList;

/**
 * Author: fangzhou
 * Date:   9/1/14.
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
    public ListNode insertionSortList(ListNode head) {
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while(cur != null) {
            ListNode iter = fakeHead;
            while(iter != null && iter.next != null && iter.next.val <= cur.val) {
                iter = iter.next;
            }
            ListNode next = iter.next;
            iter.next = cur;
            cur = cur.next;
            iter.next.next = next;
        }
        return fakeHead.next;
    }
}
