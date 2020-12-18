public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here

        int sum = 0;

        if(numbers==null || numbers.length<2){
            return sum;
        }

        int diff = Integer.MAX_VALUE;

        Arrays.sort(numbers);

        for(int i= 0; i<numbers.length; i++){
            int start = 0;
            int end = i-1;

            while(start<end){

                int currentSum = numbers[start]+numbers[end]+numbers[i];

                if(currentSum>target){

                    if(currentSum-target<diff){

                        diff = currentSum-target;
                        sum = currentSum;
                    }


                    end--;
                    
                }else{

                    if(target-currentSum<diff){

                        diff = target-currentSum;
                        sum = currentSum;
                    }

                    start++;
                }
            }
        }


        return sum;
    }
}