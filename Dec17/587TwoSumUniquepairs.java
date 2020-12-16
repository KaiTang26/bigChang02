public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here

        Arrays.sort(nums);
        int count = 0;
        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int sum = nums[start]+nums[end];

            if(sum==target){
                count++;
            }else if(sum>target){
                end--;

            }else{
                start++;
            }
        }

        return count;
    }
}
