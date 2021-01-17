public class Solution_1 {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int h;
    public int[][] triangle;
    public int ans;
    public int minimumTotal(int[][] triangle) {
        // write your code here

        this.triangle = triangle;

        this.h = triangle.length;
        this.ans = Integer.MAX_VALUE;

        traver(0, 0, 0);
        return this.ans;

    }
    public void traver(int x, int y, int sum){
        if(x==this.h){
            if(sum<this.ans){
                this.ans=sum;  
            }
            return;
        }
        traver(x+1, y, sum+this.triangle[x][y]);
        traver(x+1, y+1, sum+this.triangle[x][y]);
    }
}


public class Solution_2 {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int h;
    public int[][] triangle;

    public int minimumTotal(int[][] triangle) {
        // write your code here
        this.triangle = triangle;

        this.h = triangle.length;

        return helper(0, 0);

        

    }

    public int helper(int x, int y){

        if(x==this.h){
            return 0;
        }

        return Math.min(triangle[x][y]+helper(x+1, y), triangle[x][y]+helper(x+1, y+1));

    }
    
}


public class Solution_3 {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */

    public int h;
    public int[][] triangle;
    public int[][] hash;
   
    public int minimumTotal(int[][] triangle) {

        this.triangle = triangle;

        this.h = triangle.length;

        this.hash = new int[h][h];

        for(int i=0; i<h; i++){
            for(int j=0; j<h; j++){
                this.hash[i][j] = Integer.MAX_VALUE;
            }
        }

        return helper(0,0);
    }

    public int helper(int x, int y){

        if(x==this.h){
            return 0;
        }

        if(this.hash[x][y]!=Integer.MAX_VALUE){
            return this.hash[x][y];
        }

        this.hash[x][y] = Math.min(triangle[x][y]+helper(x+1, y), triangle[x][y]+helper(x+1, y+1));

        return this.hash[x][y];
    }
}



public class Solution_4 {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */


    public int minimumTotal(int[][] triangle) {

       

        int h = triangle.length;

        int[][] hash = new int[h][h];


        for(int i=0; i<triangle[h-1].length; i++){
            hash[h-1][i]= triangle[h-1][i];
        }


        for(int i=h-2; i>=0; i--){
            for(int j=0; j<triangle[i].length; j++){
                hash[i][j]= Math.min(hash[i+1][j], hash[i+1][j+1])+triangle[i][j];
            }
        }

        return hash[0][0];

        
    }

    
}
