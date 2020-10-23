import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix==null || matrix.length==0){
            return 0;
        }

        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int count = 0;

        List<Integer> potential = new ArrayList<Integer>();

       for(int i=0; i<matrix.length; i++){
           int firstValue = matrix[i][0];
           int lastValue = matrix[i][matrix[i].length-1];

           if(firstValue<=target || lastValue>=target){
               potential.add(i);
           }
       }

       for(Integer j : potential){

            if(binarySearch(matrix[j], target)){
                count++;
            }

       }

       return count;


    }

    public boolean binarySearch(int[] array, int tartget){

        int start = 0;
        int end = array.length-1;

        while(start+1<end){

            int mid = start + (end-start)/2;
            if(array[mid]==tartget){
                start = mid;
            }else if( array[mid]> tartget){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(array[start]==tartget){
            return true;
        }else if(array[end]==tartget){
            return true;
        }else{
            return false;
        }
    }
}