import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Non_Recursion_Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> preOrder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if(root==null){
            return preOrder;
        }

        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode node = stack.pop();

            preOrder.add(node.val);

            if(node.right!=null){
                stack.push(node.right);
            }

            if(node.left!=null){
                stack.push(node.left);
            }
        }

        return preOrder;
        
        
    }
    

}



class traverse_Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> preOrder = new ArrayList<Integer>();

        helper(preOrder, root);

        return preOrder;
       
        
        
    }

    public void helper(List<Integer> preOrder, TreeNode node){

        if(node==null){
            return;
        }

        preOrder.add(node.val);

        helper(preOrder, node.left);
        helper(preOrder, node.right);

    }
    

}



class Divide_conquer_Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> preOrder = new ArrayList<Integer>();

        if(root==null){
            return preOrder;
        }

       List<Integer> left = preorderTraversal(root.left);

       List<Integer> right = preorderTraversal(root.right);



       preOrder.add(root.val);
       preOrder.addAll(left);
       preOrder.addAll(right);
       

        return preOrder;
       
        
        
    }

    
    

}