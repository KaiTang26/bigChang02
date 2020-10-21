
package com.company;

import jdk.nashorn.internal.runtime.JSONListAdapter;

import javax.swing.plaf.SliderUI;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        boolean[][] grid = new boolean[][]{{true,true,false,false,false},{false,true,false,false,true},{false,false,false,true,true},{false,false,false,false,false},{false,false,false,false,true}};

        Solution sl = new Solution();

        int count = sl.numIslands(grid);

        System.out.println(count);



    }

}


class Coordinate{
    int X;
    int Y;

    Coordinate(int i, int j){
        this.X = i;
        this.Y = j;
    }
}


class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here

        int count = 0;

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return count;
        }

        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i< n; i++){

            for(int j=0; j< m; j++){

                if(grid[i][j]==true){

                    BSF(grid, i, j, n, m);
                    count++;
                }
            }
        }

        return count;
    }

    public void BSF(boolean[][] grid, int i, int j, int iBoundary, int jBoundary){

        int[] directionX = new int[]{0,0,-1,1};
        int[] directionY = new int[]{1,-1,0,0};

        Queue<Coordinate> queue = new LinkedList<Coordinate>();

        queue.offer(new Coordinate(i, j));
        grid[i][j] = false;

        while (!queue.isEmpty()){
            Coordinate cd = queue.poll();

            for(int k=0; k<4; k++){

                int newX = cd.X+directionX[k];
                int newY = cd.Y+directionY[k];

                if(!(newX >=0 && newY >=0 && newX < iBoundary && newY < jBoundary)){
                    continue;
                }
                if(grid[newX][newY]){
                    grid[newX][newY] = false;
                    queue.offer(new Coordinate(newX,newY));
                }
            }
        }
    }
}

