class Solution {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here

        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if(root == null){
            return results;
        }

        queue.offer(root);

        while(!queue.isEmpty()){

            ArrayList<Integer> subResults = new ArrayList<Integer>();

            int queueSize = queue.size();

            for(int i=0; i<queueSize; i++){
                TreeNode node = queue.poll();
                subResults.add(node.val);

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }

            }

            results.add(subResults);




        }

        return results;
    }
}