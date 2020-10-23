public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here

        int[] answer = new int[]{-1, -1};

        if(A==null || A.length==0){
            return answer;
        }

        answer[0] = firstPosition(A, target);

        answer[1] = lastPosition(A, target);

        return answer;
    }

    public int firstPosition(int[] A, int target){

        int start = 0;
        int end = A.length-1;

        while(start+1<end){
            int mid = start+(end-start)/2;

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
        }else if(A[end]==target){
            return end;
        }else{
            return -1;
        }
    }


    public int lastPosition(int[] A, int target){

        int start = 0;
        int end = A.length-1;

        while(start+1<end){
            int mid = start+(end-start)/2;

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
        }else if(A[start]==target){
            return start;
        }else{
            return -1;
        }
    }
}
