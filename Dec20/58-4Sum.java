import java.awt.List;
import java.util.Arrays;

public class Solution {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here

        List<List<Integer>> results = new ArrayList<>();

        if(numbers==null){
            return results;
        }
        

        Arrays.sort(numbers);


        for(int i=0; i<numbers.length-3; i++){

            if(i>0 && numbers[i]==numbers[i-1]){
                continue;
            }

            for(int j=i+1; j<numbers.length-2; j++){

                if(j!=i+1 && numbers[j]==numbers[j-1]){
                    continue;
                }

                int start = j+1;
                int end = numbers.length-1;

                while(start<end){

                    if(numbers[i]+numbers[j]+numbers[start]+numbers[end]==target){
                        List<Integer> subarray = new ArrayList<Integer>();
                        subarray.add(numbers[i]);
                        subarray.add(numbers[j]);
                        subarray.add(numbers[start]);
                        subarray.add(numbers[end]);

                        results.add(subarray);

                        end--;
                        start++;
                        while(start<end && numbers[start]==numbers[start-1]){
                            start++;
        
                        }
        
                        while(start<end && numbers[end]==numbers[end+1]){
                            end--;
                        }
                    }else if(numbers[i]+numbers[j]+numbers[start]+numbers[end]>target){

                        end--;

                    }else{
                        start++;
                    }

                }
 

            }

        }


        return results;


    }
}
