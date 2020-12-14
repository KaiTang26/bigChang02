public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0;
        int end = s.length()-1;

        while(start<end){

            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
