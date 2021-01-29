import java.util.HashMap;

public class Solution {
    /**
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        // write your code here

        Map<Integer, Set<Integer>> map = new HashMap<>();

        int len = stones.length;

        for(int i=0; i<len; i++){
            map.put(stones[i], new HashSet());
        }

        map.get(0).add(0);


        for(int i=0; i<len; i++){

            for(int key: map.get(stones[i])){

                for(int step=key-1; step<=key+1; step++){

                    int reachablePosition = step+stones[i];

                    if(step>0 && map.containsKey(reachablePosition)){
                        map.get(reachablePosition).add(step);

                    }

                }
            }

        }


        if(map.get(stones[len-1]).size()>0){
            return true;
        }else{
            return false;
        }




    }
}