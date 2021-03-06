
public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {


        if(nums.length == 0){
            return -1;
        }


        int start = 0;
        int end = nums.length-1;

        // start < end: loop end at start == end
        // start +1 < end: loop end at start+1 == end -> avoid infinity loop
        while(start+1<end){
            // end+start may greater than largest value in java
            int mid = (end-start)/2 + start;

            if(nums[mid]==target){
                end = mid;
            }

            if(nums[mid]<target){
                start = mid;
            }

            if(nums[mid]>target){
                end = mid-1;
            }
        }


        if(nums[start]==target){
            return start;
        }

        if(nums[end]== target){
            return end;
        }

        return -1;


        
       
    }
}