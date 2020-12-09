public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here

        if(A==null || B==null){
            return null;
        }
        
        int[] mergeArray = new int[A.length+B.length];
        int indexA=0, indexB=0, index = 0;

        while(indexA<A.length && indexB<B.length){

            if(A[indexA]<B[indexB]){

                mergeArray[index] = A[indexA];
                indexA++;
            }else{
                mergeArray[index] = B[indexB];
                indexB++;
            }
            index++;

        }

        while(indexA<A.length){
            mergeArray[index] = A[indexA];
            indexA++;
            index++;

        }

        while(indexB<B.length){
            mergeArray[index] = B[indexB];
            indexB++;
            index++;
        }

        return mergeArray;
    }
}