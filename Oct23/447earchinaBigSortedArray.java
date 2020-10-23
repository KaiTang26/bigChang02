public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here

        if(reader.get(0)==target){
            return 0;
        }

        int start = 1;
        int end = 1;


        // redouble size (exponential backoff)

        while(start+1<end){
            int mid = start+(end-start)/2;

            if(reader.get(mid)==target){
                end = mid;
            }else if(reader.get(mid)>target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(reader.get(start)==target){
            return start;
        }

        if(reader.get(end)==target){
            return end;
        }

        return -1;

        


    }
}