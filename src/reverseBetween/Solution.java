package reverseBetween;

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        ListNode cur = head;

        int i = 1;
        for(; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        int j = i;
        ListNode tail = cur;
        for(; j < n; j++) {
            tail = tail.next;
        }
        ListNode tailNext = tail.next;
        tail.next = null;
        ListNode headAfterReverse = reverseList(cur);
        pre.next = headAfterReverse;
        cur.next = tailNext;
        return first.next;
    }

    public ListNode reverseList(ListNode h) {
        if(h == null || h.next == null) {
            return h;
        }
        ListNode pre = null;
        ListNode cur = h;
        ListNode next = h.next;

        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void printList(ListNode n) {
        if(n != null) {
            ListNode cur = n;
            while(cur != null) {
                System.out.print(cur.val + ",");
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(5);
        h.next = new ListNode(6);
        h.next.next = new ListNode(7);
        printList(new Solution().reverseBetween(h, 3, 3));
    }
}