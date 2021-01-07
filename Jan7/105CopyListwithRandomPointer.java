 class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
}



public class Solution {
   
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here

        RandomListNode pointer_1 = head;

        while(pointer_1!=null){

            RandomListNode copy = new RandomListNode(pointer_1.label);
            copy.random = pointer_1.random;
            copy.next=pointer_1.next;
            pointer_1.next=copy;

            pointer_1=pointer_1.next.next;
        }

        RandomListNode pointer_2 = head;

        while(pointer_2!=null){

            if(pointer_2.next.random!=null){
                pointer_2.next.random = pointer_2.random.next;
            }

            pointer_2 = pointer_2.next.next;
        }

        RandomListNode newHead = head.next;
        RandomListNode pointer_3 = null;

        while(head!=null){

            pointer_3 = head.next;

            head.next = pointer_3.next;

            head = head.next;

            if(head!=null && head.next!=null){
                pointer_3.next = head.next;
            }



        }


        return newHead;


    }
}
