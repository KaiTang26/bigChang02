import java.util.Queue;

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here

        int islandCount = 0;

        for(int i=0; i<grid.length;i++){

            for(int j=0; j<grid[i].length; j++){

                if(grid[i][j]){

                    bfs(grid, i, j);

                    islandCount++;
                }

            }
        }


        return islandCount;
    }

    public void bfs(boolean[][] grid, int x, int y){

        int[] xChanges = new int[]{-1,0,1,0};
        int[] yChanges = new int[]{0,1,0,-1};
 
        int xIndexBoundary = grid.length;
        int yIndexBoundary = grid[0].length;

        Queue<Coordinator> queue = new LinkedList<Coordinator>();
        Coordinator startOpint = new Coordinator(x, y);
        queue.offer(startOpint);

        while(!queue.isEmpty()){

            Coordinator currentPoint = queue.poll();

            for(int i=0; i<4; i++){

                int newX = currentPoint.x+xChanges[i];
                int newY = currentPoint.y+yChanges[i];

                if(newX<0|newY<0|newX>=xIndexBoundary|newY>=yIndexBoundary){
                    continue;
                }

                if(grid[newX][newY]){
                    queue.add(new Coordinator(newX, newY));
                    grid[newX][newY]= false;
                }
            }
        }

    }
}

class Coordinator{

    int x;
    int y;

    public Coordinator(int x, int y){
        this.x = x;
        this.y = y;

    }


}