import java.awt.List;


// DC
public class Solution {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return al l keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here

        List<Integer> currArray = new ArrayList<Integer>();

        if(root==null){
            return currArray;
        }
        List<Integer> leftArray = searchRange(root.left, k1, k2);
        List<Integer> rightArray = searchRange(root.right, k1, k2);
        if(leftArray.size()>0){
            currArray.addAll(leftArray);
        }

        if(root.val>=k1 && root.val<=k2){
            currArray.add(root.val);
        }

        if(rightArray.size()>0){
            currArray.addAll(rightArray);
        }
        return currArray;
    }
}