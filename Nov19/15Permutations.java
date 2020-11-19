import java.awt.List;

public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here

        
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if(nums==null){

            return results;
            
        }

        helper(new ArrayList<Integer>(), new HashSet<Integer>(), nums, results);


        return results;
    }

    private void helper(List<Integer> permutation, Set<Integer> set, int[] nums, List<List<Integer>> results){


        if(permutation.size()==nums.length){
            results.add( new ArrayList(permutation));
            return;
        }

        for(int i=0; i<nums.length; i++){

            if(set.add(nums[i])){
                permutation.add(nums[i]);
                helper(permutation, set, nums, results);
                permutation.remove(permutation.size()-1);
                set.remove(nums[i]);


            }
            
        }
    }
}
