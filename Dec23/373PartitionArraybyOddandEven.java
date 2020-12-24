public class Solution {
    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {


        // write your code here

        if(nums==null || nums.length==0){
            return;
        }

        int start = 0;
        int end = nums.length-1;

        while(start<end){

            while(start<end && nums[start]%2!=0){
                    start++;
            }

            while(start<end && nums[end]%2==0){
                end--;
            }

            if(start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] =temp;
                start++;
                end--;
            }

        }
    }
}