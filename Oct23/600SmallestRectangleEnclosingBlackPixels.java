public class Main {

    public static void main(String[] args) {

        char[][] map = new char[][]{{'0', '0', '1', '0'}, {'0', '1', '1', '0'}, {'0', '1', '0', '0'}};

        Solution s = new Solution();

        int area = s.minArea(map, 0, 2);

        System.out.println(area);


    }
}




class Solution {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // write your code here

        int L = image.length-1; // x
        int W = image[0].length-1; // y

        // given: end=y, start=0; find first 1 index;
        int left = firstPosition(image, y, 'W', W, L);
        // given: end=W, start=y; find last 1 index;
        int right = lastPosition(image, y, W, 'W', W, L);
        // given: end=x, start=0; find first 1 index;
        int top = firstPosition(image, x, 'L', W, L);;
        // given: end=L, start=x; find last 1 index;
        int bottom = lastPosition(image, x, L, 'L', W, L);

        return (right-left+1)*(bottom-top+1);


    }

    public boolean travelInW(char[][] image, int wIndex, int lIndex){

        for(int i=0; i<=lIndex; i++){

            if(image[i][wIndex]=='1'){
                return true;
            }

        }

        return false;

    }

    public boolean travelInL(char[] LdirectionArray){

        for(char c : LdirectionArray){
            if(c=='1'){
                return true;
            }
        }

        return false;

    }

    public int lastPosition(char[][] image, int startIndex, int endIndex, char direction, int wIndex, int lIndex){

        int start=startIndex;
        int end = endIndex;

        while(start+1<end){

            int mid = start + (end-start)/2;

            if(direction=='W'){

                if(travelInW(image, mid, lIndex)){
                    start = mid;
                }else{
                    end = mid;
                }

            }

            if(direction == 'L'){

                if(travelInL(image[mid])){
                    start = mid;
                }else{
                    end = mid;
                }

            }
        }
        //System.out.println(direction);
        //System.out.println(start);
        //System.out.println(end);

        if(direction=='W'){
            if(travelInW(image, end, lIndex)){
                return end;
            }else{
                return start;
            }

        }

        if(direction == 'L'){

            if(travelInL(image[end])){
                return end;
            }else{
                return start;
            }

        }

        return -1;

    }

    public int firstPosition(char[][] image, int endIndex, char direction, int wIndex, int lIndex){

        int start=0;
        int end = endIndex;

        while(start+1<end){

            int mid = start + (end-start)/2;

            if(direction=='W'){

                if(travelInW(image, mid, lIndex)){
                    end = mid;
                }else{
                    start = mid;
                }

            }

            if(direction == 'L'){

                if(travelInL(image[mid])){
                    end = mid;
                }else{
                    start = mid;
                }

            }
        }

        if(direction=='W'){
            if(travelInW(image, start, lIndex)){
                return start;
            }else{
                return end;
            }

        }

        if(direction == 'L'){

            if(travelInL(image[start])){
                return start;
            }else{
                return end;
            }

        }

        return -1;

    }
}