public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here

        if(nums==null && nums.length<2){
            return -1;
        }

        int diff = Integer.MAX_VALUE;

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int sum = nums[start]+nums[end];

           if(sum>target){
            diff = Math.min(diff, sum-target);
             end--;
           }else{
            diff = Math.min(diff, target-sum);
            start++;
           }
          
        }



        return diff;



    }
}