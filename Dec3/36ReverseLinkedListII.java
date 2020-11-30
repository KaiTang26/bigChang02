
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
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        for(int i=1; i<m; i++){
            head = head.next;
        }

        ListNode preMNode = head; // head point to node m-1;
        ListNode Mnode = head.next;
        head = Mnode;  // head point to node m;
        ListNode pre = null;
        for(int i=m; i<=n; i++){
            ListNode temp = head.next;
            head.next = pre;
            pre=head;
            head = temp;
        }

        preMNode.next = pre;
        Mnode.next = head;

        return dummy.next;


        
    }
}