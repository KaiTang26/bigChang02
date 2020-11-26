
class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }


     class Solution {
        /**
         @param head: The first node of linked list
         @param x: An integer
         @return: A ListNode
         */
        public ListNode partition(ListNode head, int x) {
    
    
            // write your code here
    
            if(head==null){
                return null;
            }
    
            ListNode newHead = head;
            ListNode smallDummy = new ListNode(-1);
            ListNode smallHead = smallDummy;
            ListNode bigDummy = new ListNode(-1);
            ListNode bigHead = bigDummy;
            while(newHead!=null){
    
                ListNode next = newHead.next;
                newHead.next = null;
    
                if(newHead.val<x){
                    smallHead.next=newHead;
    
                    smallHead = newHead;
                }else{
                    bigHead.next = newHead;
    
                    bigHead = newHead;
                }
    
                newHead= next;
    
            }
    
    
            if(smallDummy.next==null){
                return bigDummy.next;
            }
            smallHead.next=bigDummy.next;
    
            return smallDummy.next;
        }
    }