public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */

     /*
        comparing with beside element to determine increasing or decreasing

     */
    public int mountainSequence(int[] nums) {
        // write your code here
        int start = 0;
        int end = nums.length-1;

        while(start+1<end){

            int mid = start+(end-start)/2;

            if(nums[mid]>nums[mid+1]){
                end = mid;
            }else{
                start = mid;
            }
        }


        return Math.max(nums[start], nums[end]);

    }
}
