import java.util.Map;
import java.util.Queue;

class Record {
      public int id, score;
      public Record(int id, int score){
          this.id = id;
          this.score = score;
      }
  }

public class Solution {


    // Q1: what if ppl score then than 5
   
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here

        Map<Integer, Queue<Integer>> stds = new HashMap();

        for(Record r: results){

            if(!stds.containsKey(r.id)){
                Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
                queue.offer(r.score);
                stds.put(r.id, queue);
            }else{
                Queue<Integer> intQ = stds.get(r.id);
                intQ.offer(r.score);
            }
        }

        Map<Integer, Double> ans = new HashMap();

        for(int key: stds.keySet()){

            Queue<Integer> q = stds.get(key);

            int sum=0;
            int count= q.size()>5? 5:q.size();

            for(int i=0; i<count; i++){
                sum +=q.poll();
            }

            double avg = sum/((double)count);

            ans.put(key, avg);
        }

        return ans;





    }
}