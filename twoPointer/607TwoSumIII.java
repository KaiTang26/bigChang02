class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */

    ArrayList<Integer> numList = new ArrayList<Integer>();


    public void add(int number) {
        // write your code here
        numList.add(number);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();

        for(int i : this.numList){
            int diff = value - i;
            if(numMap.containsKey(i)){
                return true;
            }else{
                numMap.put(diff, i);
            }
        }

        return false;


    }
}