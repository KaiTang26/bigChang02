import java.util.Queue;

public class Solution {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if(root==null){
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        boolean leftFirst = true;

        queue.offer(root);

        while(!queue.isEmpty()){

            List<Integer> level = new ArrayList<Integer>();

            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode currentNode = queue.poll();
                level.add(currentNode.val);

                    if(currentNode.left!=null){
                        queue.offer(currentNode.left);
                    }

                    if(currentNode.right !=null){
                        queue.offer(currentNode.right);
                    }
                }
            }

            if(leftFirst){
                results.add(level);

            }else{

                int start = 0;
                int end = level.size()-1;

                while(start<end){
                    int temp = level.get(start);
                    level.set(start, level.get(end));
                    level.set(end, temp);
                }

                results.add(level);

            }

            leftFirst = !leftFirst;

            
        }


        return results;





    }
}
