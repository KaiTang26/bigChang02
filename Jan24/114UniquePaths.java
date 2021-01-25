public class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here

        if(m<=0||n<=0){
            return-1;
        }

        // setup state
        int[][] pathCount = new int[m][n];
        
        // Initialization
        pathCount[0][0] = 1;
        for(int i=1; i<m; i++){
            pathCount[i][0]=1;
        }

        for(int i=0; i<n; i++){
            pathCount[0][i]=1;
        }

        //function

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                pathCount[i][j]= pathCount[i-1][j]+pathCount[i][j-1];
            }
        }

        return pathCount[m-1][n-1];


    }
}