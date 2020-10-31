
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
    public double maxAvg;
    public TreeNode maxNode;
    public int sum;
    public int nodeCount;
    public result(double maxAvg, int sum, int nodeCount){
        this.maxAvg = maxAvg;
        this.maxNode = null;
        this.sum = sum;
        this.nodeCount = nodeCount;
    }
}
public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        return helper(root).maxNode;
    }
    public result helper(TreeNode node){
        result currResult = new result(Integer.MIN_VALUE, 0, 0);
        if(node==null){
            return currResult;
        }
        result leftResult = helper(node.left);
        result rightResult = helper(node.right);
        if(leftResult.maxAvg> rightResult.maxAvg){
            currResult.maxAvg = leftResult.maxAvg;
            currResult.maxNode = leftResult.maxNode;
        }else{
            currResult.maxAvg = rightResult.maxAvg;
            currResult.maxNode = rightResult.maxNode;
        }
        currResult.sum = leftResult.sum+ rightResult.sum+ node.val;
        currResult.nodeCount = leftResult.nodeCount+rightResult.nodeCount+1;
        double calculateAvg = Double.valueOf(currResult.sum) / currResult.nodeCount;
        if(calculateAvg>currResult.maxAvg){
            currResult.maxAvg = calculateAvg;
            currResult.maxNode = node;
        }
        return currResult;
    }
}