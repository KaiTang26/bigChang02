import java.util.Arrays;

public class Solution {
    /**
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {



        if(envelopes==null || envelopes.length==0){
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            } 
        });

        int len = envelopes.length;

        // num of envelops at index i
        int[] dp = new int[len];

        for(int i=0; i<len; i++){
            dp[i]=1;
        }

        for(int i=1; i<len; i++){
            for(int j=0; j<i; j++){
                if(envelopes[i][1]>envelopes[j][1]){

                    dp[i]=Math.max(dp[i], dp[j]+1);

                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i=0; i<len; i++){
            ans= Math.max(ans, dp[i]);
        }

        return ans;
    }
}


