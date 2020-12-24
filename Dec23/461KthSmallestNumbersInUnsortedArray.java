public class Solution {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here

        return quickSelect(nums, 0, nums.length-1, k-1);
    }

    public int quickSelect(int[] nums, int start, int end, int k) {

        if(start>=end){

            return nums[start];

        }



        int left = start;
        int right = end;
        int pivot = nums[start];

        while(left<=right){

            while(left<=right && nums[left]< pivot){
                left++;
            }

            while(left<=right && nums[right]>pivot){
                right--;
            }

            if(left<=right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        if(k<=right){

           return quickSelect(nums, start, right, k);

        }

        if(k>=left){

            return quickSelect(nums, left, end, k);

        }

        return nums[k];
        
    }
}

