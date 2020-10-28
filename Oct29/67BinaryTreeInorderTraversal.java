import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.tree.TreeNode;


class traverse_Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> inOrder = new ArrayList<Integer>();

        helper(inOrder, root);
        return inOrder;
    }

    public void helper(List<Integer> inOrder, TreeNode node){

        if(node == null){
            return;
        }

        helper(inOrder, node.left);
        inOrder.add(node.val);
        helper(inOrder, node.right);

    }
}

class Divide_conquer_Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here

        List<Integer> inOrder = new ArrayList<Integer>();

        if(root==null){
            return inOrder;
        }

        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);

        inOrder.addAll(left);
        inOrder.add(root.val);
        inOrder.addAll(right);

        return inOrder;
    }
}