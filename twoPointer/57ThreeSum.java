class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        Arrays.sort(numbers);

        for(int i=0; i< numbers.length; i++){
            int target = -numbers[i];

            System.out.println(i>= 1);

            if( i>= 1 && numbers[i] == numbers[i-1]){
                continue;
            }

            twoSum(numbers, i+1, target, results);

        }

        return results;
    }

    public void twoSum(int[] numbers, int start, int target, List<List<Integer>> results){

        int left = start;

        int right = numbers.length-1;

        while(left < right){

            int sum = numbers[left] + numbers[right];

            if(sum>target){
                right--;
            }else if(sum<target){
                left++;
            }else{
                List<Integer> triplet = new ArrayList<Integer>();
                triplet.add(-target);
                triplet.add(numbers[left]);
                triplet.add(numbers[right]);
                results.add(triplet);
                left++;
                right--;

                while (left < right && numbers[left-1] == numbers[left]){
                    left++;
                }

                while (left < right && numbers[right+1] == numbers[right]){
                    right--;
                }


            }


        }

    }
}