import java.util.Queue;

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        int[] xChange = new int[]{1,1,-1,-1,2,2,-2,-2};
        int[] yChange = new int[]{2,-2,2,-2,1,-1,1,-1};
        int steps = 0;

        int xBoundary = grid.length;
        int yBoundary = grid[0].length;

        Queue<Point> queue = new LinkedList<Point>();

        grid[source.x][source.y]=true;



        queue.offer(source);
        
        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0; i<size; i++){

                Point currentPoint = queue.poll();

                if(currentPoint.x==destination.x && currentPoint.y==destination.y){
                    return steps;
                }

                for(int j=0; j<8; j++){

                    int newX = currentPoint.x+xChange[j];
                    int newY = currentPoint.y+yChange[j];

                    if(newX<0|newY<0|newX>=xBoundary|newY>=yBoundary){
                        continue;
                    }

                    if(grid[newX][newY]){
                        continue;
                    }

                    Point newPoint = new Point(newX, newY);
                    grid[newX][newY]=true;
                    queue.offer(newPoint);



                }
            }

            steps++;
        }


        return -1;
    }
}




class Point {
         int x;
         int y;
         Point() { x = 0; y = 0; }
         Point(int a, int b) { x = a; y = b; }
}