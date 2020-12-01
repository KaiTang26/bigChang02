
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}



public class Solution {
    /**
     * @param head: a ListNode
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
    
        public ListNode swapNodes(ListNode head, int v1, int v2) {
            // write your code here
    
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            head=dummy;
            ListNode firstPre = null;
            ListNode secondPre = null;
    
            while(head!=null && head.next !=null){
    
    
                if(head.next.val ==v1 || head.next.val==v2){
                    firstPre = head;
                    head = head.next;
                    break;
                }
                head = head.next;
    
            }
    
    
            while(head!=null && head.next !=null){
                if(head.next.val ==v1 || head.next.val==v2){
                    secondPre = head;
                }
                head = head.next;
    
            }
    
            System.out.println("secondPre "+secondPre.val);
    
            if(firstPre==null || secondPre==null){
                return dummy.next;
            }else{
    
                ListNode first = firstPre.next;
                ListNode second = secondPre.next;
    
                firstPre.next = second;
                secondPre.next = first;
                ListNode temp = second.next;
                second.next = first.next;
                first.next = temp;
                return dummy.next;
    
            }
    
    
        }


    
}