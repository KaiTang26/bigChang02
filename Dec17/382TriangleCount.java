public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here

        if(S==null){
            return 0;
        }

        Arrays.sort(S);

        int count = 0;

        for(int i=0; i<S.length; i++){

            int start = 0;
            int end = i-1;

    

            while(start<end){
                int sum= S[start]+S[end];

                if(sum>S[i]){
                    count += end-start;
                    end--;
                }else{
                    start++;
                }
                
            }
        }

        return count;

        
    }
}
