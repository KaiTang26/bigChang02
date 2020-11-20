import java.awt.List;
import java.util.Arrays;

import sun.jvm.hotspot.HelloWorld;

public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code her
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if(nums==null){
            return results;
        }

        Arrays.sort(nums);

        boolean[] visited= new boolean[nums.length];

        helper(new ArrayList<Integer>(), visited, nums, results);


        return results;
    }

    private void helper(List<Integer> permutations, boolean[] visited, int[] nums, List<List<Integer>> results){

        if(permutations.size()==nums.length){
            results.add(new ArrayList(permutations));

            return;
        }


        for(int i=0; i<nums.length; i++){

            if(i!=0&& nums[i]==nums[i-1]&& !visited[i-1]){

                continue;

            }

            if(visited[i]){
                continue;
            }

                visited[i] = true;
                permutations.add(nums[i]);
                helper(permutations, visited, nums, results);
                permutations.remove(permutations.size()-1);
                visited[i] = false;
            
        }
    }
};
