public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here

        if(A==null){
            return false;
        }

        if(A.length==1){
            return true;
        }



        boolean[] indexReachable = new boolean[A.length];

        indexReachable[0] = A[0]>0;


        for(int i=1; i<A.length; i++){

            indexReachable[i] = false;

            for(int j=0; j<i; j++){

                if(indexReachable[j] && A[j]>=(i-j)){
                    indexReachable[i] = true;
                    break;
                }
            }
        }


        return indexReachable[A.length-1];
    }
}
