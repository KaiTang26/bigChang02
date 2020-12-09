import java.util.HashSet;

public class Solution_1 {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */

     // binary search
    public int[] intersection(int[] nums1, int[] nums2) {


        if(nums1.length==0||nums2.length==0||nums1==null||nums2==null){
            return new int[0];
        }

        Set<Integer> ansList = new HashSet<Integer>();
        Arrays.sort(nums2);
        Arrays.sort(nums1);

        if(nums1.length>nums2.length){
            for(int i=0; i<nums1.length; i++){
                if(i>1 && nums1[i]==nums1[i-1]){
                    continue;
                }
                if(binarySearch(nums1[i], nums2)){
                    ansList.add(nums1[i]);
                }
            }
        }else{
            for(int i=0; i<nums2.length; i++){
                if(i>1 && nums2[i]==nums2[i-1]){
                    continue;
                }
                if(binarySearch(nums2[i], nums1)){
                    ansList.add(nums2[i]);
                }
            }
        }

        int[] ans = new int[ansList.size()];
        int index = 0;

        for(int i: ansList){

            ans[index++] = i;
        }

        return ans;
    }


    public boolean binarySearch(int target, int[] array){

        int start = 0;
        int end = array.length-1;

        while(start+1<end){
            int mid = start+(end-start)/2;
            if(array[mid]>target){
                end = mid;
            }else if(array[mid]<target){
                start = mid;
            }else{
                start = mid;
                break;
            }
        }

        if(array[start]==target|| array[end]==target){
            return true;
        }else{
            return false;
        }

    }
}


public class Solution_2 {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */

     // hash set
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
    }
}

public class Solution_3 {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */

     // merge
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here

        if(nums1.length==0||nums2.length==0||nums1==null||nums2==null){
            return new int[0];
        }

        Set<Integer> ansList = new HashSet<Integer>();
        Arrays.sort(nums2);
        Arrays.sort(nums1);

        int index1=0, index2=0;

        while(index1<nums1.length && index2<nums2.length){

            if(nums1[index1]==nums2[index2]){
                ansList.add(nums1[index1]);
                index1++;
                index2++;
            }else if(nums1[index1]>nums2[index2]){
                index2++;

            }else{
                index1++;

            }

        }

        int[] ans = new int[ansList.size()];
        int index = 0;

        for(int i : ansList){

            ans[index++] = i;

        }

        return ans;


    }
}