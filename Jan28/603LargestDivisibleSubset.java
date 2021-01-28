import java.text.CollationElementIterator;
import java.util.Arrays;

public class Solution {
    /**
     * @param nums a set of distinct positive integers
     * @return the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here

        List<Integer> ans = new ArrayList<Integer>();

        if(nums==null || nums.length==0){
            return ans;
        }

        int len = nums.length;

        Arrays.sort(nums);

        // dp largest subset size for i as largest number
        int[] dp = new int[len];
        int[] numLinks = new int[len];

        for(int i=0; i<len; i++){
            dp[i] = 1; 
            numLinks[i]=i;
        }


        for(int i=1; i<len; i++){

            for(int j=0; j<i; j++){

                if((nums[i]%nums[j])==0 && dp[i]<dp[j]+1){
                    dp[i]= dp[j]+1;
                    numLinks[i]=j;

                }
            }
        }


        int max = Integer.MIN_VALUE;
        int max_i=-1;

        for(int i=0; i<len; i++){
            if(dp[i]>max){
                max=dp[i];
                max_i=i;
            }
        }

        ans.add(nums[max_i]);

        while(max_i!=numLinks[max_i]){

            max_i = numLinks[max_i];

            ans.add(nums[max_i]);

        }

        Collections.reverse(ans);

        return ans;
    }


}
