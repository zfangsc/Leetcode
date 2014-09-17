package CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:  fangzhou
 * Date:    4/26/14
 * Time:    1:09 PM
 */
class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };


public class Solution {
    // iterative
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> h = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        //UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        //h.put(node, head);
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(node);
        while(!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            if(!h.containsKey(n)) {
                UndirectedGraphNode nClone = new UndirectedGraphNode(n.label);
                h.put(n, nClone);
                for(UndirectedGraphNode child : n.neighbors) {
                    nClone.neighbors.add(child);    // wrong.   TODO: fix later
                    if(!h.containsKey(child)) {
                        q.add(child);
                    }
                }
            }
        }
        return h.get(node);
    }


    // recursive
    /*public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(node == null)
            return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> h = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        return cloneGraph2(node, h);
    }

    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> h) {
        if(node == null)
            return null;


        if(h.containsKey(node)) {
            return h.get(node);
        }
        UndirectedGraphNode nodeClone = new UndirectedGraphNode(node.label);
        h.put(node, nodeClone);
        for(UndirectedGraphNode c : node.neighbors) {
            nodeClone.neighbors.add(cloneGraph2(c, h));
        }

        return nodeClone;
    }*/

    public static void main(String[] args) {
        UndirectedGraphNode n = new UndirectedGraphNode(0);
        n.neighbors.add(n);
        n.neighbors.add(n);
        Solution s = new Solution();
        UndirectedGraphNode nclone = s.cloneGraph(n);
        System.out.println(nclone.neighbors.size());
    }
}
