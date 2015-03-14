import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Administrator on 2015/3/14.
 */
public class LRUCache {
    private class Linklist{
        private LinklistNode head;
        private LinklistNode tail;
        private HashMap<Integer,LinklistNode> m;
        public Linklist(){
            head = new LinklistNode();
            tail = new LinklistNode();
            head.next = tail;
            tail.pre = head;
            m = new HashMap<Integer, LinklistNode>();

        }
        public void addStart(int k){
            LinklistNode n2 = head.next;
            LinklistNode a = new LinklistNode(k);
            head.next = a;
            a.pre = head;
            a.next = n2;
            n2.pre = a;
            m.put(k,a);
        }
        public int popStart(){
            LinklistNode n2 = head.next.next;
            LinklistNode resNode = head.next;
            head.next = n2;
            n2.pre = head;
            resNode.next = null;
            resNode.pre = null;
            int res = resNode.val;
            m.remove(res);
            return resNode.val;
        }
        public void addEnd(int k){
            LinklistNode n1 = tail.pre;
            LinklistNode a = new LinklistNode(k);
            n1.next = a;
            a.pre = n1;
            a.next = tail;
            tail.pre = a;
            m.put(k,a);
        }

        public void removeK(int k){
            LinklistNode n = m.get(k);
            LinklistNode n1 = n.pre;
            LinklistNode n2 = n.next;
            n1.next = n2;
            n2.pre = n1;
            m.remove(k);
        }
    }
    private class LinklistNode{
        public int val;
        public LinklistNode next;
        public LinklistNode pre;
        public LinklistNode(int v){
            val = v;
        }
        public LinklistNode(){
            val = 0;
        }
    }
    private Linklist keyLife;
    private HashMap<Integer, Integer> kvStore;
    private int c;
    public LRUCache(int capacity) {
        keyLife = new Linklist();
        kvStore = new HashMap<Integer, Integer>();
        c = capacity;
    }

    public int get(int key) {
        if(kvStore.containsKey(key)){
            keyLife.removeK(key);
            keyLife.addEnd(key);
            return kvStore.get(key);
        }else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if(kvStore.containsKey(key)){
            keyLife.removeK(key);
            keyLife.addEnd(key);
            kvStore.put(key,value);
        }else if(kvStore.size() < c){
            keyLife.addEnd(key);
            kvStore.put(key,value);
        }else{
            int removeKey = keyLife.popStart();
            kvStore.remove(removeKey);
            keyLife.addEnd(key);
            kvStore.put(key,value);
        }
    }
}
