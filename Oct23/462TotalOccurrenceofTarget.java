public class Solution {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */

     /*
        1: find first index of target
        2: find last index of target
        3: count = last-first+1

     */
    public int totalOccurrence(int[] A, int target) {
        // write your code here

        int count = 0;

        if(A==null || A.length==0){
            return count;
        }

        int firstIndex = firstIndex(A, target);

        if(firstIndex == -1){
            return count;
        }

        int lastIndex = lastIndex(A, target, firstIndex);

        if(lastIndex == -1){
            return 1;
        }

        count = lastIndex-firstIndex+1;

        return count;


    }

    public int firstIndex(int[] A, int target){
        int start = 0;
        int end = A.length-1;

        while(start+1<end){
            int mid = start + (end-start)/2;

            if(A[mid]==target){
                end = mid;
            }else if(A[mid]>target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(A[start]==target){
            return start;
        }

        if(A[end]==target){
            return  end;
        }

        return -1;
    }

    public int lastIndex(int[] A, int target, int startIndex){

        int start = startIndex+1;
        int end = A.length-1;

        while(start+1<end){
            int mid = start + (end-start)/2;

            if(A[mid]==target){
                start = mid;
            }else if(A[mid]>target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(A[end]==target){
            return end;
        }

        if(A[start]==target){
            return start;
        }

        return -1;

    }
}
