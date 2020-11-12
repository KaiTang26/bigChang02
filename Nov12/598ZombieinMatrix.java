import java.util.Queue;

public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        // write your code here
        int ZOMBIE = 1;
        int WALL = 2;
        int PEOPLE = 0;

        int xBoundary = grid.length;
        int yBoundary = grid[0].length;

        Queue<Coordinator> queue = new LinkedList<Coordinator>();


        int numPeople = 0;

        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[i].length;j++){
                if(grid[i][j]==ZOMBIE){

                    Coordinator newZ = new Coordinator(i, j);
                    queue.offer(newZ);
                }

                if(grid[i][j]==PEOPLE){

                    numPeople++;

                }
            }
        }


        if(queue.isEmpty()){
            return -1;
        }

        int numDays = 0;

        int[] xChanges = new int[]{-1,0,1,0};
        int[] yChanges = new int[]{0,1,0,-1};


        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0; i<size; i++){
                Coordinator currentZ = queue.poll();
                

                for(int direction=0; direction<4; direction++){

                    int newX = currentZ.x+xChanges[direction];
                    int newY = currentZ.y+yChanges[direction];

                    if(newX<0|newY<0|newX>=xBoundary|newY>=yBoundary){
                        continue;
                    }

                    if(grid[newX][newY]==PEOPLE){
                        grid[newX][newY]=ZOMBIE;
                        queue.offer(new Coordinator(newX, newY));
                        numPeople--;
                    }

                    if(grid[newX][newY]==WALL){
                        continue;
                    }

                }
            }

            numDays++;

        }


        if(numDays==0 || numPeople!=0){
            return -1;
        }else{
            return numDays-1;
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