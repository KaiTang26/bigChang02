import java.util.Queue;

public class Solution {

    private int k;
    private Queue<Integer> queue;



    /*
    * @param k: An integer
    */public Solution(int k) {
        // do intialization if necessary
        this.k = k;
        this.queue = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        this.queue.offer(num);
        return;
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> list = new ArrayList<Integer>();
        int n = this.queue.size()<this.k? this.queue.size(): this.k;
        for(int i=0; i<n; i++){
            list.add(this.queue.poll());
        }
        for(int num:list){
            this.queue.offer(num);
        }
        return list;
    }
}
