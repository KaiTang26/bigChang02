import java.util.HashSet;
import java.util.Queue;

public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here

        if(n==0){
            return false;
        }

        if(edges.length!=n-1){
            return false;
        }


        Map<Integer, Set<Integer>> graph = adjacentList(n, edges);



        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> vistedNode = new HashSet<Integer>();

        queue.add(0);
        vistedNode.add(0);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i: graph.get(node)){
                if(!vistedNode.contains(i)){
                    vistedNode.add(i);
                    queue.add(i);
                }
            }
        }

        if(vistedNode.size()!=n){
            return false;
        }

        return true;
    }

    public Map<Integer, Set<Integer>> adjacentList(int n, int[][] edges){

        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();

        for(int i=0; i<n; i++){
            graph.put(i, new HashSet<Integer>());
        }

        for(int i=0; i<edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
           graph.get(node1).add(node2);
           graph.get(node2).add(node1);
           
        }

        return graph;

    }
}
