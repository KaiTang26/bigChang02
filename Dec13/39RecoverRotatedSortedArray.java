import java.util.List;

public class Solution {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here

        int startIndex = 0;

        int endIndex = nums.size()-1;

        if(nums.get(endIndex)>nums.get(startIndex)){
            return;
        }

        while(startIndex+1<endIndex){
            int midIndex = startIndex+(endIndex-startIndex)/2;
            int start = nums.get(startIndex);
            int end = nums.get(endIndex);
            int mid = nums.get(midIndex);

            if(mid>end){
                startIndex = midIndex;
            }else{
                endIndex = midIndex;
            }
        }

        System.out.println(startIndex);

        System.out.println(endIndex);



        if(nums.get(startIndex)>nums.get(endIndex)){

            reverse(nums, 0, startIndex);
            reverse(nums, startIndex+1, nums.size()-1);
            
        }else{
            reverse(nums, 0, endIndex);
            reverse(nums, endIndex+1, nums.size()-1);
        }

        reverse(nums, 0, nums.size()-1);

    }


    public void reverse(List<Integer> nums, int start, int end){

        while(start<end){
            int temp = nums.get(end);
            nums.set(end, nums.get(start));
            nums.set(start, temp);
            start++;
            end--;
        }


    }
}




public void recoverRotatedSortedArray(List<Integer> nums) {
    // write your code here

    int startIndex = 0;

    int endIndex = nums.size()-1;


    for(int i=0; i<nums.size()-1; i++){

        if(nums.get(i)>nums.get(i+1)){

            reverse(nums, 0, i);
            reverse(nums, i+1, nums.size()-1);
            reverse(nums, 0, nums.size()-1);
            return;

        }
    }


}


