import java.util.Arrays;

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here

        int count = 0;

        if(nums==null || nums.length<=1){
            return count;
        }

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int sum = nums[start]+nums[end];

            if(sum<=target){
                start++;
                
            }else{
                count += end-start;
                end--;
               
            }
        }

        return count;
    }
}
