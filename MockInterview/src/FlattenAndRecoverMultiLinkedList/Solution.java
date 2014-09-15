package FlattenAndRecoverMultiLinkedList;

import Common.LinkedListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: fangzhou
 * Date:   9/15/14.
 */

class Segment {
    public LinkedListNode head;
    public LinkedListNode tail;
}

public class Solution {
    public LinkedListNode flatten(LinkedListNode header) {  // return tail of the current flatten list
        return flattenWithRecoverMap(header, new HashMap<LinkedListNode, LinkedListNode>());
    }

    public LinkedListNode flattenWithRecoverMap(LinkedListNode header, Map<LinkedListNode, LinkedListNode> m) {  // return tail of the current flatten list
        if (header == null) {
            return null;
        }
        LinkedListNode cur = header, pre = cur;
        while (cur != null) {
            LinkedListNode next = cur.next;
            if (cur.down != null) {
                m.put(cur, next);
                LinkedListNode subTail = flattenWithRecoverMap(cur.down, m);
                pre = subTail;
                cur.next = cur.down;    // cur -> cur.down -> subTail -> next
                cur.down = null;    // cut 'down' pointer
                subTail.next = next;

            } else {
                pre = cur;
            }
            cur = next;
        }
        return pre;
    }

    public LinkedListNode recover(LinkedListNode header, Map<LinkedListNode, LinkedListNode> m) {
        LinkedListNode cur = header;
        return recoverHelper(header, null, m).head;
    }

    public Segment recoverHelper(LinkedListNode node, LinkedListNode tail, Map<LinkedListNode, LinkedListNode> m) {
        Segment segment = new Segment();
        segment.head = node;
        while (node != null && node != tail) {
            if (m.containsKey(node)) {
                LinkedListNode next = m.get(node);
                Segment subList = recoverHelper(node.next, next, m);
                node.down = subList.head;
                node.next = next;
            }
            LinkedListNode next = node.next;
            if (node.next == tail) { // cut 'next' pointer
                node.next = null;
            }
            node = next;
        }
        return segment;
    }

    public static void main(String[] args) {
        LinkedListNode h = buildList();
        Solution s = new Solution();
        HashMap<LinkedListNode, LinkedListNode> m = new HashMap<LinkedListNode, LinkedListNode>();
        s.flattenWithRecoverMap(h, m);
        System.out.println(h.next);
        s.recover(h, m);
        System.out.println(h.next);

    }

    private static LinkedListNode buildList() {
        LinkedListNode head = new LinkedListNode(0);
        head.down = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        LinkedListNode three = new LinkedListNode(3);
        head.next.down = three;
        three.down = new LinkedListNode(4);
        three.next = new LinkedListNode(5);
        return head;
    }

}
