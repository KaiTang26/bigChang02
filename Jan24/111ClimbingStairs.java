public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if(n<0){
            return -1;
        }

        if(n<=2){
            return n;
        }

        //setup state
        int[] pathCount = new int[n];

        for(int i=0; i<2; i++){
            pathCount[i]=i+1;
        }

        for(int i=2; i<n; i++){
            pathCount[i] = pathCount[i-1]+pathCount[i-2];
        }

        return pathCount[n-1];


    }
}
