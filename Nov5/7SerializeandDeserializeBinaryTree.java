public class Main {

    public static void main(String[] args) {

        Solution sl = new Solution();

        TreeNode root = sl.deserialize("{1,2,3,11,#,4,5,#,#,6,7,#,10,#,#,8,9,#,#,12,13,#,#,#,#,#,14}");



        String rt = sl.serialize(root);

        System.out.println(rt);


        

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




class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here


        if(root==null){
            return"{}";
        }

        StringBuilder sb = new StringBuilder();

        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();

        queue.add(root);

        for(int i=0; i<queue.size(); i++){
            TreeNode currentNode = queue.get(i);

            if(currentNode==null){
                continue;
            }
            queue.add(currentNode.left);
            queue.add(currentNode.right);
        }

        while(queue.get(queue.size()-1)==null){
            queue.remove(queue.size()-1);
        }

        sb.append("{");
        sb.append(queue.get(0).val);

        for(int i=1; i<queue.size(); i++){
            if(queue.get(i)==null){
                sb.append(",#");
            }else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }

        sb.append("}");

        return  sb.toString();


    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data.equals("{}")){
            return null;
        }

        String[] nodeVals = data.substring(1,data.length()-1).split(",");
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeVals[0]));
        nodes.add(root);

        boolean isLeft = true;
        int index = 0;

        for(int i=1; i<nodeVals.length; i++){

            if(!nodeVals[i].equals("#")){
                TreeNode newNode = new TreeNode(Integer.parseInt(nodeVals[i]));
                nodes.add(newNode);
                if(isLeft){
                    nodes.get(index).left = newNode;
                }else{
                    nodes.get(index).right = newNode;
                }
            }

            if(!isLeft){
                index++;
            }

            isLeft = !isLeft;
        }

        return root;



    }
}
