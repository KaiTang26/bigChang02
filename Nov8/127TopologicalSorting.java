import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import jdk.nashorn.internal.ir.IdentNode;

class DirectedGraphNode {
         int label;
         ArrayList<DirectedGraphNode> neighbors;
         DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
};




public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here

        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        ArrayList<DirectedGraphNode> results = new ArrayList<DirectedGraphNode>();

        if(graph==null){
            return results;
        }

        Map<DirectedGraphNode, Integer> indegrees = new HashMap<DirectedGraphNode, Integer>();

        for(DirectedGraphNode i : graph){
            for(DirectedGraphNode j : i.neighbors){

                if(!indegrees.containsKey(j)){
                    indegrees.put(j, 1);
                }else{
                    indegrees.put(j, indegrees.get(j)+1);
                }

            }
        }

        

        for(DirectedGraphNode i: graph){

            if(!indegrees.containsKey(i)){
                queue.add(i);
                results.add(i);
            }
        }


        while(!queue.isEmpty()){

            DirectedGraphNode node = queue.poll();

            for(DirectedGraphNode i: node.neighbors){

                indegrees.put(i, indegrees.get(i)-1);

                if(indegrees.get(i)==0){
                    queue.add(i);
                    results.add(i);
                }
            }

        }


        return results;
    }
}
