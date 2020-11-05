import java.util.List;
import java.util.Queue;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
         }
    }

class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
}




public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here

        
        List<ListNode> nodeList = new ArrayList<ListNode>();
        if(root==null){
            return nodeList;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                ListNode newNode = new ListNode(node.val);
                head.next= newNode;
                head = newNode;

                if(node.left!=null){
                    queue.offer(node.left);
                }

                if(node.right!=null){
                    queue.offer(node.right);
                }
            }

            nodeList.add(dummy.next);
        }


        return nodeList;
    }
}