public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] ans = new int[2];

        int left = 0;
        int right = 0;

        int sum = 0;

        while(right<numbers.length){

            if(numbers[left]>target){
                left++;
            }

            if(numbers[right]>target){
                right++;
            }


        }
    }
}
