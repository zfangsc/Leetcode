package MergekSortedLists;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Author: fangzhou
 * Date:   8/30/14.
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
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.isEmpty()) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode head : lists) {
            if(head != null) {
                queue.add(head);
            }
        }
        ListNode fakeHead = new ListNode(-1);
        ListNode cur = fakeHead;
        while(!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if(cur.next != null) {
                queue.add(cur.next);
            }
        }
        return fakeHead.next;
    }
}
