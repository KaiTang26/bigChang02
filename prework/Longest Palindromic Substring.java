class Solution {
    /**
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) return "";
        // write your code here
        int startIndex = 0;
        int endIndex = 0;


        for(int i=0; i < s.length(); i++){

            int lenForOdd = findPalindrome(s, i, i);
            int lenForEven = findPalindrome(s, i, i+1);

            int len = Math.max(lenForOdd, lenForEven);
            if (len > endIndex- startIndex) {
                startIndex = i - (len - 1) / 2;
                endIndex = i + len / 2;
            }

        }

        return s.substring(startIndex, endIndex+1);


    }

    public int findPalindrome (String s, int left, int right){
        int l = left;
        int r = right;
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;

        }
        return r-l-1;
    }
}
