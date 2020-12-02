import java.util.List;

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
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here

        if(head ==null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){

            if(slow.equals(fast)){
                break;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast==null || slow==null || fast.next == null){
            return null;
        }

        while (head != slow.next) { 
            head = head.next;
            slow = slow.next;
        }
        return head;		
    }
}