import java.util.Map;
import java.util.Queue;

class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<UndirectedGraphNode>();
      }
  }



public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here

        if(node == null){
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        queue.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        while(!queue.isEmpty()){
            UndirectedGraphNode currentNode = queue.poll();
            UndirectedGraphNode currentNodeCopy = map.get(currentNode);
            
            for(UndirectedGraphNode neighbor: currentNode.neighbors){

                

                if(!map.containsKey(neighbor)){
                    UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newNode);
                    queue.add(neighbor);
                    currentNodeCopy.neighbors.add(newNode);
                }else{


                    currentNodeCopy.neighbors.add(map.get(neighbor));

                    
                }

               
                
            }

            
        }

        return map.get(node);

    }
}