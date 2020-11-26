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
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here

        if(l1==null && l2==null){
            return null;
        }

        if(l1==null){
            return l2;
        }

        if(l2==null){
            return l1;
        }





        ListNode l1Head = l1;
        ListNode l2Head = l2;

        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;

        while(l1Head!=null && l2Head!=null){

            if(l1Head!=null && l2Head!=null && l1Head.val<=l2Head.val){

                dummyHead.next = l1Head;
                dummyHead = l1Head;
                l1Head = l1Head.next;

            }

            if(l1Head!=null && l2Head!=null && l2Head.val<=l1Head.val){
                dummyHead.next = l2Head;
                dummyHead = l2Head;
                l2Head = l2Head.next;

            }

        }

        if(l1Head!=null){
            dummyHead.next= l1Head;
        }

        if(l2Head!=null){
            dummyHead.next = l2Head;
        }

        return dummy.next;
    }
}
