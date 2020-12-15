import java.util.Map;

public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    Map<Integer, Integer> map;
    List<Integer> list;

    public TwoSum(){
        this.map = new HashMap<Integer, Integer>();
        this.list = new ArrayList<Integer>();
    }


    public void add(int number) {
        // write your code here
        this.list.add(number);

        if(this.map.containsKey(number)){
            this.map.put(number, map.get(number)+1);
        }else{
            this.map.put(number, 1);
        }
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here

        for(int i: list){

            int num = value-i;

            if(i!=num && map.containsKey(num) ){
                return true;
            }

            if(i == num && map.get(num)>1){
                return true;
            }

        }

        return false;
    }
}
