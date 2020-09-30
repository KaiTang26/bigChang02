// 1: from one node to get all nodes in graph
// 2: clone nodes for all nodes
// 3: connect new nodes based on input graph (cope edges)


import java.util.*;

public class Main {

    public static void main(String[] args) {

        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(4);

        ArrayList<UndirectedGraphNode> node1Nerghbors = new ArrayList<UndirectedGraphNode>();
        node1Nerghbors.add(node2);
        node1Nerghbors.add(node3);
        node1.neighbors = node1Nerghbors;

        ArrayList<UndirectedGraphNode> node2Nerghbors = new ArrayList<UndirectedGraphNode>();
        node2Nerghbors.add(node1);
        node2Nerghbors.add(node3);
        node2.neighbors = node2Nerghbors;

        ArrayList<UndirectedGraphNode> node3Nerghbors = new ArrayList<UndirectedGraphNode>();
        node3Nerghbors.add(node1);
        node3Nerghbors.add(node2);
        node3.neighbors = node3Nerghbors;





    }

}


 class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<UndirectedGraphNode>();
      }
 }

 class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if(node == null){
            return null;
        }
        // write your code here

        List<UndirectedGraphNode> nodeArray = getAllNodes(node);

        Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        for(UndirectedGraphNode n: nodeArray){
            nodeMap.put(n, new UndirectedGraphNode(n.label));
        }

        for(UndirectedGraphNode n: nodeArray){
            UndirectedGraphNode newNode = nodeMap.get(n);

            for(UndirectedGraphNode nb: n.neighbors ){
                UndirectedGraphNode newNb = nodeMap.get(nb);
                newNode.neighbors.add(newNb);
            }
        }

        return nodeMap.get(node);
    }

    private List<UndirectedGraphNode>  getAllNodes(UndirectedGraphNode root){

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        queue.offer(root);
        set.add(root);

        while (!queue.isEmpty()){

            UndirectedGraphNode node = queue.poll();

            for (UndirectedGraphNode n : node.neighbors){

                if(!set.contains(n)){
                    set.add(n);
                    queue.offer(n);
                }
            }

        }

        ArrayList<UndirectedGraphNode> results = new ArrayList<UndirectedGraphNode>(set);

        return results;

    }
}