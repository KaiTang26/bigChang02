public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here

        int[] prefixSum = new int[nums.length];

        
        for(int i=0; i<nums.length; i++){

            if(i!=0){
                prefixSum[i] = prefixSum[i-1]+nums[i];
            }else{
                prefixSum[i] = nums[i];
            }
        }

       

        int target = Integer.MAX_VALUE;

        for(int v : prefixSum){
            int td = Math.abs(target-0);
            int vd = Math.abs(v-0);
            if(vd<td){
                target =v;
            }
        }


        int left = 0;
        int right = 0;
        int sum = nums[0];

        while(left<nums.length && right<nums.length && left<=right){

            if(sum==target){
                break;
            }else if(sum<target){
                right++;
                sum += nums[right];
            }else{
                left++;
                sum -= nums[left];
            }

        }

        int[] ans = new int[2];

        ans[0] = left;
        ans[1] = right;

        return ans;
    }
}
