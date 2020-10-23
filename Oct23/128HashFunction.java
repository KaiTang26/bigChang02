/*
    (a+b)%p = (a%p + b%p)%p

    (a-b)%p = (a%p - b%p)%p

    (a * b)%p = (a%p * b%p)%p

*/

 

class Solution {
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */


     // wrong solution
    public int hashCode_wrong(char[] key, int HASH_SIZE) {
        // write your code here

        int length = key.length-1;

         long sum = 0;

        for(char s : key){
            sum = sum + ((int)s*(int)Math.pow(33, length));
            length--;
        }
        
        return (int )sum%HASH_SIZE;
    }

    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here

        long sum = 0;

        for(char s : key){
            sum = (sum*33 + s)%HASH_SIZE;
        }

        return (int)sum;
    }
}