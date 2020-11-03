import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Solution {
    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if(root==null){
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);


        while(!queue.isEmpty()){
            int size = queue.size();

            List<Integer> level = new ArrayList<Integer>();

            for(int i=0; i<size; i++){

                TreeNode node = queue.poll();

                level.add(node.val);

                if(node.left!=null){

                    queue.offer(node.left);

                }

                if(node.right != null){
                    queue.offer(node.right);
                }

            }

            results.add(level);
        }


        int start = 0;
        int end = results.size()-1;

        while(start<end){

            List<Integer> temp = results.get(start);

            results.set(start, results.get(end));
            results.set(end, temp);

            start++;
            end--;
        }

        return results;
    }
}