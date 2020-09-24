class Solution_1 {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here

        Arrays.sort(nums);


    }
}


class Solution_2 {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
//        pointer i use to go through list
//        left side of left all 0
//        right side of right all 2
        int i = 0;
        int left = 0;
        int right = nums.length-1;
        while(i<=right){

            if(nums[i]==0){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
                i++;
            }else if(nums[i]==2){
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;

            }else{
                i++;
            }


        }

    }
