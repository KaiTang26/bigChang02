public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here

        if(nums==null || nums.length<k || k<=0){
            return new int[0];
        }

        int[] results = new int[nums.length-k+1];

        int index=0;

        int slow = 0;
        int fast = 0;

        while(fast<nums.length){

            if(fast<k){

                if(slow==fast){
                    results[index] = nums[slow];
                }else{
                    results[index] += nums[fast];
                }
                fast++;
            }else{
                index++;
                results[index] = results[index-1]+nums[fast]-nums[slow];
                slow++;
                fast++;
            }

        }

        return results;


    }
}