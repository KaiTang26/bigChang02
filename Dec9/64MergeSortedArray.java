public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int[] temp = new int[m];

        for(int i=0; i<m; i++){
            temp[i] = A[i];
        }

        int indexM =0, indexN=0, indexA=0;

        while(indexM<m && indexN<n){
            
            if(temp[indexM]<B[indexN]){
                A[indexA] = temp[indexM];
                indexM++;
            }else{
                A[indexA] = B[indexN];
                indexN++;
            }

            indexA++;
        }

        while(indexM<m){
            A[indexA] = temp[indexM];
            indexM++;
            indexA++;
        }

        while(indexN<n){
            A[indexA] = B[indexN];
            indexN++;
            indexA++;
        }
    }
}
