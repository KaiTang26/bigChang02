// 62
public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        if(A==null || A.length==0){
            return -1;
        }
        // write your code here
        int start = 0;
        int end = A.length-1;
        while(start+1<end){
            int mid = start + (end - start)/2;
           if(A[mid]>A[end] && A[mid]<target){
               start = mid;
           }else if(A[mid]>A[end] && A[mid]>target){
                if(target<A[end]){
                    start = mid;
                }else if(target>A[end]){
                    end = mid;
                }else{
                    start = mid;
                }
           }else if(A[mid]<A[end] && A[mid]>target){
               end = mid;
           }else if(A[mid]<A[end] && A[mid]<target){
                if(target<A[end]){
                    start = mid;
                }else if(target>A[end]){
                    end = mid;
                }else{
                    start = mid;
                }
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
}
