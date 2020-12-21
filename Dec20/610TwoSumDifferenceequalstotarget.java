public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if(nums==null){
            return new int[0];
        }
        Arrays.sort(nums);
        target = Math.abs(target);
        int fast = 0;
        for(int slow=0; slow<nums.length; slow++){
            if(fast==slow){
                fast+=1;
            }
            while(fast<nums.length && nums[fast]-nums[slow]<target){
                fast++;
            }
            if(fast>=nums.length){
                break;
            }
            if(nums[fast]-nums[slow]==target){
                return new int[]{nums[slow], nums[fast]};
            }
        }
        return new int[] {-1, -1};
    }
}