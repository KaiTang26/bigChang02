public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here

        if(nums==null){
            return new int[0];
        }

        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int sum = nums[start]+nums[end];

            if(sum==target){
                break;
            }else if(sum>target){
                end--;
            }else{
                start++;
            }
        }

        return new int[]{start+1, end+1};
    }
}
