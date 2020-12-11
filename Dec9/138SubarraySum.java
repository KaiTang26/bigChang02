import java.util.Map;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here

        List<Integer> answer = new ArrayList();

        Map<Integer, Integer> map = new HashMap();

        map.put(0, -1);

        int prefixSum = 0;
        
        for(int i=0; i<nums.length; i++){

            prefixSum +=nums[i];

            if(map.containsKey(prefixSum)){
                answer.add(map.get(prefixSum)+1);
                answer.add(i);
                return answer;
            }else{
                map.put(prefixSum, i);
            }
        }

        return answer;



    }
}