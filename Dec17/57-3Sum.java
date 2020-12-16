import java.awt.List;

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();

        if(numbers==null){
            return results;
        }

        Arrays.sort(numbers);

        for(int i=0; i<numbers.length-2; i++){

            if(i>0 && numbers[i]== numbers[i-1]){
                continue;
            }

            int target = -numbers[i];

            int start = i+1;
            int end = numbers.length-1;

            

            twoSum(target, start, end, results, numbers);

        }

        return results;
    }

    public void twoSum(int target, int start, int end, List<List<Integer>> results, int[] numbers){

        
        while(start<end){

            int sum = numbers[start]+numbers[end];

            if(sum==target){
                List<Integer> triplets = new ArrayList();
                triplets.add(-target);
                triplets.add(numbers[start]);
                triplets.add(numbers[end]);
                results.add(triplets);

                start++;
                end--;

                while(start<end && numbers[start]==numbers[start-1]){
                    start++;

                }

                while(start<end && numbers[end]==numbers[end+1]){
                    end--;
                }
                
            }else if(sum>target){
                end--;

            }else{
                start++;
            }

        }

    }
}