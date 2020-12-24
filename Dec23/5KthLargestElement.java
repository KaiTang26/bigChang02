public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
    }


    private int quickSelect(int[] nums, int left, int right, int k){

        int pivot = nums[left];

        int i=left;
        int j = right;

        while(i<=j){

            while(i<=j && nums[i]<pivot){
                i++;
            }

            while(i<=j && nums[j]>pivot){
                j--;
            }

            if(i<=j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        
    }
}
