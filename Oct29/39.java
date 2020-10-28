// 39
public class Solution {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        for(int i=0; i<nums.size(); i++){
            if(i+1<nums.size() && nums.get(i)>nums.get(i+1)){
                reverse(nums, 0, i);
                reverse(nums, i+1, nums.size()-1);
                reverse(nums, 0, nums.size()-1);
                break;
            }
        }
    }
    public void reverse(List<Integer> nums, int start, int end){
        int left = start;
        int right = end;
        while(left<right){
            int temp = nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, temp);
            left++;
            right--;
        }
    }
}
