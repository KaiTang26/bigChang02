import java.util.Queue;

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */

    private Comparator<Record> IntComparator = new Comparator<Record>(){
        public int compare(Record a, Record b){
            return a.val-b.val;
        }
    };



    public int kthSmallest(int[][] matrix, int k) {


        if(matrix==null){
            return -1;
        }
        // write your code here

        int size = 0;

        Queue<Record> queue = new PriorityQueue<Record>(IntComparator);


        for(int i=0; i<matrix.length; i++){
            if(matrix[i].length>0){
                queue.offer(new Record(i, 0, matrix[i][0]));
                size+=matrix[i].length;
            }
        }


        int n = size>k?k:size;

        int ans = -1;

        for(int i=0; i<n; i++){

            Record r = queue.poll();

            ans = r.val;

            if(r.col+1<matrix[r.row].length){

                queue.offer(new Record(r.row, r.col+1, matrix[r.row][r.col+1]));

            }

        }


        return ans;



    }
}



class Record{

    int row;
    int col;
    int val;

    public Record(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;

    }
}