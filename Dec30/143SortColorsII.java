public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        
        if(colors==null|| colors.length<k){
            return;
        }

        rainbowSort(colors, 0, colors.length-1, 1, k);
    }


    private void rainbowSort(int[] color, int start, int end, int cf, int ce){

        if(cf==ce){
            return;
        }

        if(start>=end){
            return;
        }

        
        int left = start;
        int right = end;

        int cm = cf+(ce-cf)/2;

        while(left<=right){

            while(left<=right && color[left]<=cm){
                left++;
            }

            while(left<=right && color[right]>cm){
                right--;
            }

            if(left<=right){
                int temp = color[left];
                color[left] = color[right];
                color[right] = temp;
                right--;
                left++;
            }

        }


        rainbowSort(color, start, right, cf, cm);
        rainbowSort(color, left, end, cm+1, ce);



    }
}
