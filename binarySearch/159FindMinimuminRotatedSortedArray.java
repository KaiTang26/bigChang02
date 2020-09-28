class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here

        int start = 0;
        int end = nums.length-1;
        int firstX = nums[end];


        while (start+1<end){
            int mid = start+(end-start)/2;
            if(nums[mid]>firstX){
                start = mid;
            }else if(nums[mid]<firstX){
                end = mid;
            }else{
                end = mid;
            }
        }


        return Math.min(nums[start], nums[end]);
    }
}