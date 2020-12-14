public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        int left = 0;
        int right = 0;

        while(right<nums.length){

            if(nums[right]!=0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }

            right++;  
           
        }
    }
}
