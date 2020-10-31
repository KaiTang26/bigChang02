package com.company;
import jdk.nashorn.internal.runtime.JSONListAdapter;
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
public class HbSolution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public int minSum = Integer.MAX_VALUE;
    public TreeNode minNode;
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        if(root==null){
            return root;
        }
        int sum = helper(root);
        return minNode;
    }
    public int helper(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftSum = helper(node.left);
        int rightSum = helper(node.right);
        int sum = leftSum+rightSum+node.val;
        if(sum<minSum){
            minSum=sum;
            minNode = node;
        }
        return sum;
    }
}
class DCSolution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        return helper(root).minNode;
    }

    
    public result helper (TreeNode node){
        result newResult = new result(Integer.MAX_VALUE, 0);
        if(node==null){
            return newResult;
        }
        result left = helper(node.left);
        result right = helper(node.right);


        if(left.minSum< right.minSum){
            newResult.minSum= left.minSum;
            newResult.minNode = left.minNode;
        }else{
            newResult.minSum= right.minSum;
            newResult.minNode = right.minNode;
        }



        newResult.sum = left.sum+ right.sum+ node.val;
        if(newResult.sum< newResult.minSum){
            newResult.minSum = newResult.sum;
            newResult.minNode = node;
        }
        return newResult;
    }
}
class result{
    public int minSum;
    public int sum;
    public TreeNode minNode;
    public  result(int value, int sum){
        this.minSum = value;
        this.minNode = null;
        this.sum = sum;
    }
}














