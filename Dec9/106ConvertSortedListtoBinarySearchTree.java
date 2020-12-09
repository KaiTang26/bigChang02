
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
          this.next = null;
      }
  }
  
  public class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
 


public class Solution {
    
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here

        if(head==null){
            return null;
        }

        ListNode middle = getMiddle(head);
        
        TreeNode node = new TreeNode(middle.val);
        TreeNode right = sortedListToBST(middle.next);
        node.right = right;

        if(head!=middle){
            TreeNode left = sortedListToBST(head);
            node.left = left;
        }
        
        
        return node;
    }


    public ListNode getMiddle(ListNode head){

        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast !=null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(pre!=null){
            pre.next = null;
        }

        return slow;
    }
}
