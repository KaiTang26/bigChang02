import javax.lang.model.util.ElementScanner6;

public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here

        if(matrix==null || matrix.length==0){
            return false;
        }

        int startRow = 0;

        int endRow = matrix.length-1;

        while(startRow+1<endRow){
            int midRow = startRow + (endRow-startRow)/2;
            int firstValue = matrix[midRow][0];
            int lastValue = matrix[midRow][matrix[midRow].length-1];

            if(firstValue == target){
                startRow = midRow;
            }else if(lastValue == target){
                endRow = midRow;
            }else if(firstValue>target){
                endRow = midRow;
            }else if(lastValue<target){
                startRow = midRow;
            }else{
                startRow = midRow;
            }
        }

        if(binarySearch(matrix[startRow], target)){
            return true;
        }else if(binarySearch(matrix[endRow], target)){
            return true;
        }else{
            return false;
        }



    }

    public boolean binarySearch(int[] array, int target){


        int start = 0;
        int end = array.length-1;

        while(start+1<end){
            int mid = start + (end-start)/2;

            if(array[mid]==target){
                start = mid;
            }else if(array[mid]>target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(array[start]== target){
            return true;
        }else if(array[end]== target){
            return true;
        }else{
            return false;
        }


    }
}
