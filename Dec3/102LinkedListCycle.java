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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if(head==null){
            return false;
        }

        ListNode slow = head;

        ListNode fast = head.next;

        while(fast!=null && fast.next !=null){

            if(slow.equals(fast)){
                return true;
            }

            slow = slow.next;

            fast = fast.next.next;


        }

        return false;
    }
}