public class Solution_1 {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here

        int count = 1;
        int ans = 1;
        Arrays.sort(num);
        for(int i=0; i<=num.length-2; i++){

            if(num[i]+1==num[i+1]){
                count++;
            }else{

                if(num[i]!=num[i+1]){
                    count=1;
                }
            }
            
            if(count>ans){
                    ans=count;
                }
        }
        
        return ans;
    }
}


public class Solution_2 {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here

        Set<Integer> set = new HashSet<Integer>();

        for(int i: num){
            set.add(i);
        }

        int count = 0;


        for(int j:num){

            if(set.contains(j)){
                set.remove(j);

                int down = j-1;
                int up = j+1;

                while(set.contains(down)){
                    set.remove(down);
                    down--;
                }

                while(set.contains(up)){
                    set.remove(up);
                    up++;
                }


                count = Math.max(count, up-down-1);



            }


        }

        return count;
    }
}
