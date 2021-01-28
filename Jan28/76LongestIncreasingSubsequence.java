public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here

        if(nums==null || nums.length==0){
            return 0;
        }

        int len = nums.length;
        int[] numsSubLens = new int[len];

        for(int i=0; i<len; i++){
            numsSubLens[i]=1;
        }

        for(int i=1; i<len; i++){
            for(int j=0; j<i; j++){

                if(nums[j]<nums[i]){
                    numsSubLens[i]= Math.max(numsSubLens[i], numsSubLens[j]+1);
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i=0; i<len; i++){

            ans=Math.max(ans, numsSubLens[i]);
        }

        return ans;
    }
}
