
class Solution{
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here

        if(A.length==0){
            return -1;
        }



        int start = 0;
        int end = A.length-1;

        while (start+1<end){
            int mid = start + (end-start)/2;

            int midValue = A[mid];

            if(mid+1<A.length && midValue>A[mid+1] && midValue>A[mid-1]){
                return mid;
            }else if(mid+1<A.length && midValue<A[mid+1] && midValue<A[mid-1]){

                start = mid;

            }else if(mid+1<A.length && midValue>A[mid+1] && midValue<A[mid-1]){

                end = mid;

            }else{
                start = mid;
            }

        }

        if(A[start]>A[end]){
            return start;
        }else{
            return end;
        }
    }
}