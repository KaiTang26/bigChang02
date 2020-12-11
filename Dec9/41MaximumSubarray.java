import java.awt.List;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here

        if(nums.length==0){
            return 0;
        }

        int[] kadaneSum = new int[nums.length];
        kadaneSum[0] = nums[0];

        int max = kadaneSum[0];

        for(int i=1; i<nums.length; i++){

            kadaneSum[i] = Math.max(kadaneSum[i-1], 0)+nums[i];

            max = Math.max(kadaneSum[i], max);

        }

        return max;

        

    }
}
