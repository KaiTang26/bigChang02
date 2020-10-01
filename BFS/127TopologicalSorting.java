class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
};


class Solution {
  /*
   * @param graph: A list of Directed graph node
   * @return: Any topological order for the given graph.
   */
  public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
      // write your code here

      if(graph==null){
          return new ArrayList<DirectedGraphNode>();
      }



      Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);

      List<DirectedGraphNode> startNodes = getStartNodes(indegree, graph);

      ArrayList<DirectedGraphNode> order = BFS(startNodes, indegree);

      if(order.size() == graph.size()){
          return order;
      }


      return null;
  }

  public ArrayList<DirectedGraphNode> BFS(List<DirectedGraphNode> startNodes, Map<DirectedGraphNode, Integer> indegree){

      ArrayList<DirectedGraphNode> order = new ArrayList<DirectedGraphNode>();

      Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

      for(DirectedGraphNode n: startNodes){
          queue.offer(n);
          order.add(n);
      }

      while (!queue.isEmpty()){

          DirectedGraphNode node = queue.poll();

          for(DirectedGraphNode n: node.neighbors){

              indegree.put(n, indegree.get(n)-1);

              if(indegree.get(n)==0){
                  queue.offer(n);
                  order.add(n);
              }

          }

      }

      return order;

  }

  public Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph){

      Map<DirectedGraphNode, Integer> indegree = new HashMap<DirectedGraphNode, Integer>();

      for(DirectedGraphNode n: graph){
          if(!indegree.containsKey(n)){
              indegree.put(n, 0);
          }
          for(DirectedGraphNode nb: n.neighbors){
              if(!indegree.containsKey(nb)){
                  indegree.put(nb, 1);
              }else{
                  indegree.put(nb, indegree.get(nb)+1);
              }
          }
      }

      return indegree;

  }

  public List<DirectedGraphNode> getStartNodes(Map<DirectedGraphNode, Integer> indegree, ArrayList<DirectedGraphNode> graph){

      List<DirectedGraphNode> results = new ArrayList<DirectedGraphNode>();

      for(DirectedGraphNode n: graph){
          int count = indegree.get(n);
          if(count ==0){
              results.add(n);
          }
      }
      return results;
  }
}