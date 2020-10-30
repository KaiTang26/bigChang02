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
class result{
    public int maxDepth;
    public boolean isBalance;
    public result(int maxDepth, boolean isBalance){
        this.maxDepth = maxDepth;
        this.isBalance = isBalance;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return helper(root).isBalance;
    }
    public result helper(TreeNode node){
        if(node==null){
            return new result(0, true);
        }
        result leftResult = helper(node.left);
        result rightResult = helper(node.right);
        if(!leftResult.isBalance || !rightResult.isBalance){
            return new result(-1, false);
        }
        if(Math.abs(leftResult.maxDepth- rightResult.maxDepth)>1){
            return new result(-1, false);
        }
        return new result(Math.max(leftResult.maxDepth, rightResult.maxDepth)+1, true);
    }
}
