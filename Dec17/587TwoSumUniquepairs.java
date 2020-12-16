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

            if(start>0 && nums[start]==nums[start-1]){
                start++;
                continue;
            }

            if(end!=nums.length-1 && nums[end]==nums[end+1]){
                end--;
                continue;
            }

            if(sum==target){
                count++;
                start++;
                end--;
            }else if(sum>target){
                end--;

            }else{
                start++;
            }
        }

        return count;
    }
}
