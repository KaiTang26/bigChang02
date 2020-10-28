import java.util.concurrent.ArrayBlockingQueue;

public class Solution {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here

        List<Integer> postOrder = new ArrayList<Integer>();

        if(root==null){
            return postOrder;
        }

        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);

        postOrder.addAll(left);
        postOrder.addAll(right);
        postOrder.add(root.val);

        return postOrder;
    }
}