package LRUCache;

import java.util.HashMap;

/**
 * Author:  fangzhou
 * Date:    4/13/14
 * Time:    10:51 AM
 */
class node {
    node next;
    node prev;
    int key;
    int value;
    public node(int k, int v) {
        this.key = k;
        this.value = v;
    }
}

class Cache {
    node head;
    node tail;
    HashMap<Integer, node> h = new HashMap<Integer, node>();
    public Cache() {
    }

    public void raise(int key) {
        if(h.containsKey(key)) {
            node n = h.get(key);
            if(head == n) {
                return;
            }
            node next = n.next;
            node prev = n.prev;
            if(tail == n) {
                tail = prev;
            }
            prev.next = next;
            if(next != null) {
                next.prev = prev;
            }
            n.next = head;
            n.prev = null;
            head.prev = n;
            head = n;
        }
    }

    public void add(int key, int value) {
        if(h.containsKey(key)) {
            setValue(key, value);
        } else {
            h.put(key, new node(key, value));
            addNode(h.get(key));
        }
        raise(key);
    }

    public void deleteTail() {
        if(tail != null) {
            int key = tail.key;
            if(head == tail) {
                head = null;
                tail = null;
            }
            else {
                tail.prev.next = null;
                tail = tail.prev;
            }
            h.remove(key);
        }
    }

    public int getValue(int key) {
        return h.get(key).value;
    }

    public boolean containsKey(int key) {
        return h.containsKey(key);
    }

    public int size() {
        return h.size();
    }

    // internal
    private void setValue(int key, int value) {
        node n = h.get(key);
        n.value = value;
    }

    // internal
    private void addNode(node n) {
        if(tail != null) {
            tail.next = n;
            n.prev = tail;
            tail = n;
        } else {
            head = n;
            tail = n;
        }
    }
}

public class LRUCache {
    int capacity;
    Cache cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new Cache();
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            cache.raise(key);
            return cache.getValue(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if(!cache.containsKey(key)) {
            while(cache.size() >= capacity) {
                cache.deleteTail();
            }
        }
        cache.add(key, value);
    }

    public static void main(String[] args) {
        //3,[set(1,1),set(2,2),set(3,3),set(4,4),get(4),get(3),get(2),get(1),set(5,5),get(1),get(2),get(3),get(4),get(5)]
        //2,[set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)]

        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2,1);
        lruCache.set(1,1);
        System.out.println(lruCache.get(2));
        lruCache.set(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
/*        lruCache.set(1,1);
        lruCache.set(2,2);
        lruCache.set(3,3);
        lruCache.set(4,4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.set(5,5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));*/
    }


}