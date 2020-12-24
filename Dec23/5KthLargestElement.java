public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here

        return quickSelect(nums, 0, nums.length-1, nums.length-n);
    }


    private int quickSelect(int[] nums, int start, int end, int k){

        if(start>=end){
            return nums[k];
        }

        int pivot = nums[start];

        int left=start;
        int right = end;

        while(left<=right){


            while(left<=right && nums[left]<pivot){
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
