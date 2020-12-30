//Definition for ListNode
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
 
public class Solution {
    /** @param hashTable: A list of The first node of linked list
      @return: A list of The first node of linked list which have twice size
    */
      

    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here

        int currentCapacity = hashTable.length;

        if(currentCapacity<=0){
            return hashTable;
        }

        int capacity = currentCapacity*2;

        ListNode[] newHashTable = new ListNode[capacity];

        for(int i=0; i<currentCapacity; i++){
            ListNode node = hashTable[i];

            while(node!=null){
                int key = hashcode(node.val, capacity);

                if(newHashTable[key]==null){
                    newHashTable[key] = new ListNode(node.val);
                }else{

                    ListNode head = newHashTable[key];

                    while(head!=null&&head.next!=null){
                        head= head.next;
                    }

                    head.next = new ListNode(node.val);

                }
                
                node = node.next;
            }
        }

        return newHashTable;


    }

    private int hashcode(int key, int capacity){

        return (key%capacity+capacity)%capacity;
    }
};

