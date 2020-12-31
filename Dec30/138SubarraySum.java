import java.util.Map;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        List<Integer> result = new ArrayList();

        int sum = 0;

        map.put(sum, 0); 

        for(int i=0; i<nums.length; i++){
            sum +=nums[i];

            if(map.containsKey(sum)){

               
                result.add(map.get(sum));
                result.add(i);
                return result;


            }else{
                map.put(sum, i+1);
            }
        }

        return result;
    }
}
