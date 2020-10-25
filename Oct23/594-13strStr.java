import org.graalvm.compiler.hotspot.nodes.PluginFactory_BeginLockScopeNode;

import jdk.tools.jlink.resources.plugins;
import sun.security.provider.HashDrbg;

public class Solution {
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */

    /*  1: get size of target -> m
        2: calculate 33^m % hashSize
        3: calculate target hash value;
        4: loop through source calcuate hash value for size of m
        5: for each calculate value comparing with target hash value
        

    */

    public int strStr2(String source, String target) {
        // Write your code here

        if(source==null || target==null){
            return -1;
        }

        if(source.equals(target) || target.equals("")){
            return 0;
        }

        
        int targetSize = target.length();

        int hashSize = 1000000;

        int hashBase = 1;

        for(int i=0; i<targetSize; i++){
            hashBase = (hashBase*33)%hashSize;
        }

        int targetHashValue = hashFunction(target, hashSize);

        int sourceHashValue = 0;

        for(int i=0; i<source.length(); i++){

            sourceHashValue= (sourceHashValue*33+source.charAt(i))%hashSize;

            if(i < targetSize-1){
                continue;
            }

            if(i>=targetSize){

                int removeIndex = i-targetSize;
                char removeChar = source.charAt(removeIndex);

                sourceHashValue = (sourceHashValue - (removeChar*hashBase)%hashSize)%hashSize;

                if(sourceHashValue<0){
                    sourceHashValue+=hashSize;
                }


            }

            if(sourceHashValue==targetHashValue){
                String potentalSubString = source.substring(i-targetSize+1, i+1);
                if(potentalSubString.equals(target)){
                    return i-targetSize+1;
                }
            }



        }

        return -1;


    }

    public int hashFunction(String str, int hashSize){

        long hashValue = 0;
        for(char c : str.toCharArray()){
            hashValue = (hashValue*33 + c)%hashSize;
        }
        return (int)hashValue;
    }


}