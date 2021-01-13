import java.util.Queue;

public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */


    private Comparator<Integer> IntComparator = new Comparator<Integer>(){
        public int compare(Integer a, Integer b){
            return b-a;
        }
    };




    public int[] topk(int[] nums, int k) {
        // write your code here

        int n = nums.length>k?k:nums.length;

        int[] ans= new int[n];

        Queue<Integer> queue = new PriorityQueue<Integer>(IntComparator);

        for(int i: nums){
            queue.offer(i);
        }

        for(int j=0; j<n; j++){

            ans[j]=queue.poll();
        }

        return ans;
    }
}
