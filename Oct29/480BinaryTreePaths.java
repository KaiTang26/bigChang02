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
public class DCSolution {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> path = new ArrayList<String>();
        if(root==null){
            return path;
        }
        if(root.right==null && root.left==null){
            String value = Integer.toString(root.val);
            path.add(value);
            return  path;
        }
        List<String>  left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for(String l : left){
            path.add(root.val+"->"+l);
        }
        for(String r : right){
            path.add(root.val+"->"+r);
        }
        return path;
    }
}
public class TrSolution {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> results = new ArrayList<String>();
        helper(root,"", results);
        return results;
    }
    public void helper(TreeNode node, String path, List<String> results){
        if(node==null){
            return;
        }
        String currPath;
        if(path.equals("")){
            currPath=Integer.toString(node.val);
        }else{
            currPath = path+"->"+node.val;
        }
        if(node.right==null && node.left==null){
            results.add(currPath);
            return;
        }
        helper(node.left, currPath, results);
        helper(node.right, currPath, results);
    }
}























