class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code her
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int answer = 0;

        for(char c: s.toCharArray()){

            if(charMap.containsKey(c)){
                charMap.put(c, charMap.get(c)+1);
            }else{
                charMap.put(c,1);
            }
        }

        for(char c: charMap.keySet()){

            int value = charMap.get(c);

            answer += (value/2) * 2;

            if(answer%2==0 && value%2 ==1){
                answer++;
            }


        }


        return answer;
    }
}