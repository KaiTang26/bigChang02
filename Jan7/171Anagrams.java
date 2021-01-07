import java.awt.List;

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here

        List<String> ans = new ArrayList<String>();

        Map<String, List<String>> map = new HashMap<String, List<String>>();


        for(String i: strs){

            char[] charArray = i.toCharArray();
            Arrays.sort(charArray);

            String key = new String(charArray);

            if(!map.containsKey(key)){
                List<String> list = new ArrayList<String>();
                list.add(i);
                map.put(key, list);
            }else{
                map.get(key).add(i);
            }

        }


        for(List<String> list: map.values()){

            if(list.size()>1){
                ans.addAll(list);
            }

            
        }

        return ans;




    }
}
