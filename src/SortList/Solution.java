package SortList;

/**
 * Author: fangzhou
 * Date:   8/19/14.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class ListResult {
    ListNode head;
    ListNode tail;

    public ListResult(ListNode h, ListNode t) {
        head = h;
        tail = t;
    }

    public ListResult() {
        head = null;
        tail = null;
    }

    public void appendAndCut(ListNode n) {
        if(n == null) {
            return;
        }
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = tail.next;
        }
        tail.next = null;
    }

    public void appendAndCut(ListResult n) {
        if(n == null || n.head == null) {
            return;
        }
        if(this.head == null) {
            this.head = n.head;
            this.tail = n.tail;
        } else {
            this.tail.next = n.head;
            this.tail = n.tail;
        }
        tail.next = null;
    }
}

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return quickSort(head).head;
    }

    public ListResult quickSort(ListNode n) {
        if (n == null) {
            return new ListResult();
        }
        if (n.next == null) {
            return new ListResult(n, n);
        }
        ListNode cur = n.next;
        ListResult larger = new ListResult();
        ListResult equal = new ListResult(n, n);
        ListResult smaller = new ListResult();
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val > n.val) {
                larger.appendAndCut(cur);
            } else if(cur.val < n.val) {
                smaller.appendAndCut(cur);
            } else {
                equal.appendAndCut(cur);
            }
            cur = next;
        }
        larger = quickSort(larger.head);
        smaller = quickSort(smaller.head);
        smaller.appendAndCut(equal);
        smaller.appendAndCut(larger);
        return smaller;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode cur = head;
        cur.next = new ListNode(1);
        cur = cur.next;
        cur.next = new ListNode(8);
        cur = cur.next;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(-5);
        cur = cur.next;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(2);

        print(head);
        head = new Solution().sortList(head);
        print(head);
    }

    private static void print(ListNode head) {
        System.out.println("**************");
        ListNode cur = head;
        while(cur != null) {
            System.out.println(cur.val+",");
            cur = cur.next;
        }
    }
}