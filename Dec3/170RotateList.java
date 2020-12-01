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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(head==null){
            return null;
        }
        ListNode initHead = head;
        int length = 1;

        while(head.next!=null){
            head = head.next;
            length++;
        }

        int realStep = k%length;

        if(realStep==0){
            return initHead;
        }

        head.next = initHead;

        for(int i=0; i<(length-realStep-1); i++){
            initHead = initHead.next;
        }

        ListNode newHead = initHead.next;

        initHead.next = null;

        return newHead;
    }
}