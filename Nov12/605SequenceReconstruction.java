import java.util.Map;
import java.util.Queue;

public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here

        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();

        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();


        for(int i:org){
            graph.put(i, new HashSet<Integer>());
            indegree.put(i, 0);
        }

        int orgSize = org.length;
        int seqsCountSize = 0;


        for(int[] seq: seqs){
            seqsCountSize+=seq.length;

            if(seq.length>=1 && (seq[0]<=0 || seq[0]>orgSize)){
                return false;
            }


            for(int i=1; i<seq.length; i++){


                if((seq[i]<=0 || seq[i]>orgSize)){
                    return false;
                }



                if(graph.get(seq[i-1]).add(seq[i])){
                    indegree.put(seq[i], indegree.get(seq[i])+1);
                }
            }
        }


        if(seqsCountSize<orgSize){
            return false;
        }


        Queue<Integer> queue = new LinkedList<Integer>();

        for(int key: indegree.keySet()){
            if(indegree.get(key)==0){
                queue.offer(key);
            }
        }

        int reconstructedOrgCount = 0;

        while(queue.size()==1){
            int ele = queue.poll();

            for(int next: graph.get(ele)){
                indegree.put(next, indegree.get(next)-1);

                if(indegree.get(next)==0){
                    queue.offer(next);
                }
            }

            if(ele!=org[reconstructedOrgCount]){
                return false;
            }

            reconstructedOrgCount++;
        }


        return reconstructedOrgCount==org.length;
    }
}