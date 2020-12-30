import java.util.Map;

public class LRUCache {

    private class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }

    private int capacity;

    private Map<Integer, Node> map = new HashMap<Integer, Node>();

    private Node head = new Node(-1, -1);

    private Node tail = new Node(-1, -1);


    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if(!map.containsKey(key)){
            return -1;
        }


        // remove current node from linkList
        Node current = map.get(key);

        current.pre.next = current.next;
        current.next.pre = current.pre;

        // move current to tail

        current.pre = tail.pre;
        tail.pre = current;
        current.pre.next = current;
        current.next = tail;
       


        return map.get(key).value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here

        if(get(key)!=-1){
            map.get(key).value=value;
            return;
        }

        if(map.size()>=this.capacity){
            map.remove(head.next.key);
            head.next=head.next.next;
            head.next.pre = head;
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);

        newNode.pre = tail.pre;
        tail.pre = newNode;
        newNode.pre.next = newNode;
        newNode.next = tail;

    }
}
