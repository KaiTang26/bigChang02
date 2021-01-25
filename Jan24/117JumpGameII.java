public class Solution {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here


        int len = A.length;

        int[] minSteps = new int[len];

        minSteps[0] = 0;

        for(int i=1; i<len; i++){

            minSteps[i] = Integer.MAX_VALUE;

            for(int j=0; j<i; j++){

                if(A[j]>=i-j){
                    minSteps[i]= Math.min(minSteps[i], minSteps[j]+1);
                }

            }
        }

        return minSteps[len-1];



    }
}
