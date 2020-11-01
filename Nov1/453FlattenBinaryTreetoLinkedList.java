public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here

        helper(root);
    }

    public TreeNode helper(TreeNode node){


        if(node==null){
            return null;
        }


        TreeNode left = helper(node.left);
        TreeNode right = helper(node.right);

        if(left==null && right == null){
            return node;
        }

        if(left == null && right != null){
            return right;
        }

        if(left !=null && right == null){
            node.right = node.left;
            node.left = null;
            return left;
        }

        TreeNode tempRight = node.right;

        node.right = node.left;
        left.right = tempRight;
        node.left = null;

        return right;


    }
}
