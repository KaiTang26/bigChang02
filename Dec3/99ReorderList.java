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
     * @return: nothing
     */
    public void reorderList(ListNode head) {
        // write your code here

        if(head==null){
            return;
        }

    
        ListNode midNode = getMidNode(head);

        ListNode reverseHead = reverse(midNode.next);

        midNode.next = null;

        merge(head, reverseHead);

    
    }

    public ListNode getMidNode(ListNode head){
        ListNode snow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            snow = snow.next;
            fast = fast.next.next;
        }
        return snow;

    }

    public ListNode reverse(ListNode head){

        ListNode pre = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;

    }

    public void merge(ListNode h1, ListNode h2){

        ListNode h1Head = h1.next;

        ListNode tail = h1;

        int index = 0;

        while(h1Head!=null && h2!=null){
            index++;

            if(index%2!=0){
                tail.next = h2;
                h2 = h2.next;
            }else{
                tail.next = h1Head;
                h1Head = h1Head.next;
            }

            tail = tail.next;

        }

        if(h1Head!=null){
            tail.next = h1Head;
        }

        if(h2!=null){
            tail.next = h2;
        }

    }

   
}

