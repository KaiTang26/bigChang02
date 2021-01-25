public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here

        if(grid==null||grid.length==0){
            return -1;
        }
        int xLen = grid.length;
        int yLen = grid[0].length;

        // setup state pathSum at this point
        int[][] sum = new int[xLen][yLen];


        // Initialization
        sum[0][0] = grid[0][0];

        for(int i=1; i<xLen; i++){
            sum[i][0] = sum[i-1][0]+grid[i][0];
        }
        for(int i=1; i<yLen; i++){
            sum[0][i] = sum[0][i-1]+grid[0][i];
        }
        // state transfor function
        for(int i=1; i<xLen; i++){
            for(int j=1; j<yLen; j++){
                sum[i][j]= Math.min(sum[i-1][j], sum[i][j-1])+grid[i][j];
            }
        }

        return  sum[xLen-1][yLen-1];



    }
}
