public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here

        if(nums.length<=1){
            return 0;
        }

        int count = 0;

        Arrays.sort(nums);

            int start = 0;
            int end = nums.length-1;

            while(start<end){
                int sum = nums[start]+nums[end];

                if(sum<=target){
                    count += end-start;
                    start++;

                }else{
                    end--;
                }
            }

        return count;
        
    }
}
