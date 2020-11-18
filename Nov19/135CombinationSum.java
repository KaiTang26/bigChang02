import java.awt.List;

import sun.security.krb5.internal.crypto.crc32;

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        helper(0, new ArrayList<Integer>(), candidates, target, 0, result);

        return result;
       
    }

    private void helper(int first, List<Integer> subSet, int[] candidates, int target, int sum, List<List<Integer>> result){

        if(target==sum){
            result.add(new ArrayList(subSet));
            return;

        }


        for(int i=first; i<candidates.length; i++){

            if(i>0 && candidates[i-1]==candidates[i]){
                continue;
            }
            
            if(sum+candidates[i]<=target){
                System.out.println(sum+candidates[i]);
                subSet.add(candidates[i]);
                helper(i, subSet, candidates, target, sum+candidates[i], result);
                subSet.remove(subSet.size()-1);
                
            }else{
                break;
            }


        }

        return;
    }
    
   
}