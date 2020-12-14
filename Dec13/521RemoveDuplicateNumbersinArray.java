public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here

        Set<Integer> set = new HashSet();

        for(int i : nums){
            set.add(i);
        }

        int count=0;

        for(int j : set){
            nums[count++] = j;
        }

        return count;

    }
}
