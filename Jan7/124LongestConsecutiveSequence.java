public class Solution {
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
