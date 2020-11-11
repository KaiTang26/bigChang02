import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import sun.text.normalizer.UBiDiProps;

class UndirectedGraphNode {
         int label;
        ArrayList<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) { 
             label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
         }
};


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // write your code here

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> visitedSet = new HashSet<UndirectedGraphNode>();

        queue.add(node);
        visitedSet.add(node);

        while(!queue.isEmpty()){
            UndirectedGraphNode currentNode = queue.poll();

            if(values.get(currentNode)==target){
                return currentNode;

            }

            for(UndirectedGraphNode n: currentNode.neighbors){
               

                    if(!visitedSet.contains(n)){

                        visitedSet.add(n);
                        queue.add(n);

                    }

                

                
            }
        }


        return null;
    }
}