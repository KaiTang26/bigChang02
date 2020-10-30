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
class DCSolution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root==null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
class TrSolution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int depth;
    public int maxDepth(TreeNode root) {
        // write your code here
        this.depth = 0;
        helper(root, 1);
        return this.depth;
    }
    public void helper(TreeNode node, int currdepth){
        if(node==null){
            return;
        }
        if(currdepth>this.depth){
            this.depth = currdepth;
        }
        helper(node.left, currdepth+1);
        helper(node.right, currdepth+1);
    }
}