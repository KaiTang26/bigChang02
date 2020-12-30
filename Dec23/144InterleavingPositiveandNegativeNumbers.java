public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        // write your code here

        if(A==null || A.length==0){
            return;
        }

        int start = 0;
        int end = A.length-1;

        while(start<end){

            while(start<end && A[start]<0){
                start++;
            }

            while(start<end && A[end]>0){
                end--;
            }

            if(start<end){
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;
                start++;
                end--;
            }

        }


        int left;
        int right;


        if(2*end==A.length){

            left = 0;
            right = A.length-1;

        }else if(2*end<A.length){
            left = 0;
            right = 2*end;
        }else{
            left = A.length-end;
            right = A.length-1;
        }



    
        while(left<right){
            if(left<right){
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left+=2;
                right-=2;
            }
        }
    }
}
