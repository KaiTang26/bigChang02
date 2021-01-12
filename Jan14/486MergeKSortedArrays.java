import java.util.Queue;

import org.graalvm.compiler.lir.alloc.trace.lsra.TraceLinearScanLifetimeAnalysisPhase.Analyser;

class Record{

    public int col;
    public int row;
    public int value;

    public Record(int col, int row, int value ){
        this.col = col;
        this.row = row;
        this.value = value;

    }
}



public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    private Comparator<Record> RecordComparator = new Comparator<Record>(){
        public int compare(Record a, Record b){
            return a.value-b.value;
        }
    };


    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here

        if (arrays == null) {
            return new int[0];
        }

        int size=0;

        Queue<Record> queue = new PriorityQueue<Record>( RecordComparator);

        for(int i=0; i<arrays.length; i++){

            if(arrays[i].length>0){
                Record r = new Record(i, 0, arrays[i][0]);
                queue.offer(r);
                size+=arrays[i].length;
            }
        }

        int[] ans = new int[size];

        for(int i=0; i<size; i++){

            Record item = queue.poll();

            ans[i] = item.value;

            if(item.row+1<arrays[item.col].length){

                Record r = new Record(item.col, item.row+1, arrays[item.col][item.row+1]);
                queue.offer(r);

            }

        }


        return ans;




    }
}
