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

        int left = 0;
        int right = nums.length-1;
        
        while(left<right){
            
            int sum = nums[left] + nums[right];
            if(sum>target){
                right--;
            }else if(sum<target){
                left++;
            }else{
                
                count++;
                right--;
                left++;
                
                while(left<right && nums[right] == nums[right+1]){
                    right--;
                }

                while(left<right && nums[left] == nums[left-1]){
                    left++;
                }
                
            }
        }



        return count;
    }
}