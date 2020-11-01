import java.util.ArrayList;

class TreeNode{
    public int val;
    public TreeNode left;
    public  TreeNode right;
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class result{
    public boolean isValid;
    public TreeNode maxNode;
    public TreeNode minNode;

    public result(boolean isValid){
        this.maxNode = null;
        this.minNode = null;
        this.isValid = isValid;
    }

}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here

        return helper(root).isValid;
        
    }

    public result helper(TreeNode node){

        if(node==null){
            return new result(true);
        }

       

        result left = helper(node.left);
        result right = helper(node.right);

        if(!left.isValid || !right.isValid){
            return new result(false);
        }else if((left.maxNode!= null && left.maxNode.val>=node.val) || (right.maxNode!= null &&right.minNode.val<=node.val)){
            return new result(false);
        }

        result result = new result(true);
        result.minNode = left.minNode != null ? left.minNode : node;
        result.maxNode = right.maxNode != null ? right.maxNode : node;
        
        return result;





       

    }
}
