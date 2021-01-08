import java.util.List;
import java.util.Queue;

public class ListNode {
         int val;
         ListNode next;
         ListNode(int val) {
             this.val = val;
             this.next = null;
         }
     }



public class Solution {
    

    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
        public int compare(ListNode a, ListNode b){
            return a.val-b.val;
        }
    };



    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here

        if(lists==null || lists.size()==0){
            return null;
        }

        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);

        for(int i=0; i<lists.size(); i++){

            if(lists.get(i)!=null){
                queue.offer(lists.get(i));
            }

        }

        ListNode dummy = new ListNode(-1);

        ListNode tail = dummy;

        while(!queue.isEmpty()){

            ListNode node = queue.poll();

            tail.next = node;
            tail = tail.next;

            if(node.next!=null){
                queue.offer(node.next);
            }




        }

        return dummy.next;



    }
}
