import java.awt.List;

import sun.jvm.hotspot.HelloWorld;

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {

        Arrays.sort(nums);
        // write your code here

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        int length = nums.length;

        for(int i=0; i<=length; i++){

            helper(0, i, new ArrayList<Integer>(), results, nums);

        }

        return results;


    }

    public void helper(int first, int subSetLength, List<Integer> subSet, List<List<Integer>> results, int[] nums){

        if(subSet.size() == subSetLength){

            results.add(new ArrayList(subSet));
        }

        for(int i=first; i<nums.length; i++){
             subSet.add(nums[i]);

             helper(i+1, subSetLength, subSet, results, nums);

             subSet.remove(subSet.size()-1);
        }

    }
}
