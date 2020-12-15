class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here

        if(numbers==null){
            return new int[0];
        }

        Pair[] pairs = new Pair[numbers.length];

        for(int i=0; i<numbers.length; i++){
            pairs[i] = new Pair(numbers[i], i);
        }

        Arrays.sort(pairs, new SortbyVal());

        int start = 0;
        int end = numbers.length-1;

        while(start<end){
            int sum = pairs[start].val+pairs[end].val;

            if(sum==target){
                break;
            }else if(sum>target){
                end--;
            }else{
                start++;
            }
        }

        int[] results = new int[]{pairs[start].index, pairs[end].index};

        Arrays.sort(results);

        return results;
    }


    class Pair {

        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;

        }

    }

    class SortbyVal implements Comparator<Pair>{

        public int compare(Pair a, Pair b){
            return a.val-b.val;
        }
    }
}



