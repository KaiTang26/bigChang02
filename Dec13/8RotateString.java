public class Solution {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {


        // write your code here

        if (str == null || str.length == 0)
            return;

        offset = offset % str.length;

        revoice(str, 0, str.length-1);

        revoice(str, 0, offset-1);

        revoice(str, offset, str.length-1);
    }

    public void revoice(char[] str, int start, int end){


        while(start<end){

            char temp = str[end];
            str[end] = str[start];
            str[start] = temp;
            start++;
            end--;
        }
    }
}
