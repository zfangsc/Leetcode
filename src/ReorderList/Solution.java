package ReorderList;

/**
 * Author:  fangzhou
 * Date:    4/10/14
 * Time:    11:47 PM
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
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        ListNode cur = new ListNode(2);
        n.next = cur;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);
        //cur = cur.next;
        Solution s = new Solution();
        s.reorderList(n);
        print(n);
    }

    public static void print(ListNode n) {
        ListNode cur = n;
        System.out.println("<<<<<<<<");
        while(cur != null) {
            System.out.print(cur.val + ",");
            cur = cur.next;
        }
        System.out.println("\n>>>>>>>>>");
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        ListNode cur = head, faster = head;
        while(faster != null) {
            faster = faster.next;
            if(faster == null) {
                break;
            }
            faster = faster.next;
            if(faster == null) {
                break;
            }
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = null;
        ListNode rev = reverse(next);
        merge(head, rev);
    }

    public ListNode reverse(ListNode n) {
        if(n == null || n.next == null) {
            return n;
        }
        ListNode cur = n.next, prev = n;
        prev.next = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public void merge(ListNode l1, ListNode l2) {
        ListNode cur1 = l1.next, cur2 = l2, prev = l1;
        while(cur2 != null || cur1 != null) {
            if(cur2 != null) {
                prev.next = cur2;
                cur2 = cur2.next;
                prev = prev.next;
            }
            if(cur1 != null) {
                prev.next = cur1;
                cur1 = cur1.next;
                prev = prev.next;
            }
        }
    }
}
