public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        // write your code here

        if(root==null || p==null){
            return null;
        }

        if(root.val<=p.val){
            TreeNode rightNode = inorderSuccessor(root.right, p);
            return rightNode;
        }else{

            TreeNode leftNodo = inorderSuccessor(root.left, p);
            if(leftNodo == null){
                return root;
            }else{
                return leftNodo;
            }

        }


        
    }
}
