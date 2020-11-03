import java.util.ArrayList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Solution {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here


        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if(root==null){
            return results;
        }



        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<Integer>();

            int levelSize = queue.size();

            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();

                levelList.add(node.val);

                if(node.left !=null){
                    queue.offer(node.left);
                }

                if(node.right !=null){
                    queue.offer(node.right);
                }
            }


            results.add(levelList);

        }


        return results;
    }
}