import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) 
         { this.label = x; }
}


class Solution_1 {
    
    public RandomListNode copyRandomList(RandomListNode head) {

        if(head==null){
            return null;
        }
        // write your code here

        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode pre = dummy;
        RandomListNode newNode = null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while(head!=null){
            if(map.containsKey(head)){
                newNode = map.get(head);
            }else{
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }

            pre.next = newNode;

            if(head.random!=null){

                if(map.containsKey(head.random)){

                    newNode.random = map.get(head.random);

                }else{
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                    
                }
                
            }
            pre = pre.next;
            head = head.next;
        }

        return dummy.next;
    }
}


class Solution_2 {
    
    public RandomListNode copyRandomList(RandomListNode head) {

        if(head == null){
            return null;
        }

        copyNext(head);

        copyRandom(head);

        return splitList(head);

        
    }

    public void copyNext(RandomListNode head){
        
        while(head!=null){
            RandomListNode temp = head.next;
            head.next = new RandomListNode(head.label);
            head.next.next = temp;
            head = temp;
        }
    }

    public void copyRandom(RandomListNode head){

        while(head !=null && head.next !=null){

            if(head.random!=null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    public RandomListNode splitList(RandomListNode head){
        RandomListNode dummy = new RandomListNode(-1);
        dummy.next = head.next;
        RandomListNode newHead = head.next;

        while(head!=null){

            head.next = newHead.next;
            if(newHead.next!=null){
                newHead.next = newHead.next.next;
            }
            head = head.next;
            newHead = newHead.next;
        }

        return dummy.next;
    }
}
    