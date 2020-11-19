import java.awt.List;

import sun.jvm.hotspot.HelloWorld;

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here

        Arrays.sort(num);

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        helper(0, new ArrayList<Integer>(), num, 0, target, results);


        return results;
    }

    private void helper(int start, List<Integer> subset, int[] num, int sum, int target, List<List<Integer>> results){

        if(sum==target){
            results.add(new ArrayList(subset));
            return;
        }


        for(int i=start; i<num.length; i++){


            //make same number into sublevel
            if(i!=start && num[i]==num[i-1]){
                continue;
            }


            if(sum+num[i]>target){
                break;
            }

            subset.add(num[i]);

            helper(i+1, subset, num, sum+num[i], target, results);

            subset.remove(subset.size()-1);
        }

        return;



    }
}