

import javax.swing.plaf.SliderUI;
import java.util.*;
public class Main {
    public static void main(String[] args) {
    }
}
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
    public boolean hasA;
    public boolean hasB;
    public TreeNode LCA;
    public result(boolean hasA, boolean hasB){
        this.hasA = hasA;
        this.hasB = hasB;
        this.LCA = null;
    }
    public result(boolean hasA, boolean hasB, TreeNode LCA){
        this.hasA = hasA;
        this.hasB = hasB;
        this.LCA = LCA;
    }
}
public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here

        return helper(root, A, B).LCA;
    }
    public result helper (TreeNode node, TreeNode A, TreeNode B){
        if(node==null){
            return new result(false, false);
        }
        result left = helper(node.left, A, B);
        result right = helper(node.right, A, B);
        if(node == A && node == B){
            return new result(true, true, node);
        }else if(node == A && (left.hasB || right.hasB)){
            return new result(true, true, node);
        }else if(node == B && (left.hasA || right.hasA)){
            return new result(true, true, node);
        }else if(left.hasA && left.hasB){
            return left;
        }else if(right.hasA && right.hasB){
            return right;
        }else if(right.hasB && left.hasA){
            return new result(true, true, node);
        }else if(left.hasB && right.hasA){
            return new result(true, true, node);
        }else if(node == A && node != B){
            return new result(true, false);

        }else if(node != A && node == B){
            return new result(false, true);
        }else if(node !=A || node !=B){

            if(left.hasA || left.hasB){
                return left;
            }else if(right.hasA || right.hasB){
                return right;
            }

            new result(false, false);
            

        }
            
        return new result(false, false);
       
    }
}