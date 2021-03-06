public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here

        int left = 0;
        int right = nums.length-1;
        int i=0;

        while(i<=right){

            if(nums[i]==1){
                i++;
            }else if(nums[i]==0){
                swap(nums, i, left);
                left++;
                i++;

            }else{
                swap(nums, i, right);
                right--;
            }
        }
    }



    private void swap(int[] nums, int i, int j){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
