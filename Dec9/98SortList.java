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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here

        if(head==null || head.next==null){
            return head;
        }

        ListNode middle = findMiddle(head);

        ListNode right = sortList(middle.next);
        middle.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right){

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;

        while(left!=null && right !=null){

            if(left.val<right.val){

                pre.next = left;
                left = left.next;
            }else{
                pre.next = right;
                right = right.next;

            }
            pre = pre.next;
        }

        if(left!=null){
            pre.next = left;
        }

        if(right!=null){
            pre.next = right;
        }


        return dummy.next;
    }


    public ListNode findMiddle(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){

            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
