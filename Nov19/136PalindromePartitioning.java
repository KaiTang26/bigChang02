import java.awt.List;

import sun.awt.www.content.audio.basic;
import sun.jvm.hotspot.HelloWorld;

public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here

        List<List<String>> results = new ArrayList<List<String>>();

        if(s==null || s.length()==0){
            return results;
        }

        helper(0, new ArrayList<String>(), results, s);


        return results;
    }


    private void helper(int startIndex, List<String> subList, List<List<String>> results, String s){


        if(startIndex==s.length()){
            results.add(new ArrayList(subList));
            return;
        }


        for(int i=startIndex; i<s.length(); i++){

            String subString = s.substring(startIndex, i+1);

            if(!isPalindrome(subString)){
                continue;

            }

            subList.add(subString);
            helper(i+1, subList, results, s);
            subList.remove(subList.size()-1);


        }

    }

    private boolean isPalindrome(String subS){

        int start = 0;
        int end = subS.length()-1;

        while(start<end){
            
            if(subS.charAt(start)==subS.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }

        return true;
    }
}
