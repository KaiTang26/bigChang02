import java.util.Queue;

public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if(nodes==null){
            return results;
        }

        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        
        

        for(UndirectedGraphNode node: nodes){

            if(!set.contains(node)){
                Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
                queue.offer(node);
                set.add(node);
                List<Integer> subArray = new ArrayList<Integer>();

                while(!queue.isEmpty()){
                    UndirectedGraphNode currentNode = queue.poll();
                    
                    subArray.add(currentNode.label);

                    for(UndirectedGraphNode n: currentNode.neighbors){
                        
                        if(!set.contains(n)){
                            set.add(n);
                            queue.offer(n);

                        }
                    }

                    

                }

                Collections.sort(subArray);

                results.add(subArray);
                
            }
        }

        return results;
    }
}



class UndirectedGraphNode {
         int label;
         ArrayList<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };