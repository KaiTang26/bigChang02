

  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
 

public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */

    private Point origin;

    private Comparator<Point> PointerComparator = new Comparator<Point>(){
        public int compare(Point a, Point b){

            int distanceA = distance(a);
            int distanceB = distance(b);

            int diff = distanceA-distanceB;

            if(diff==0){

                diff = a.x-b.x;

            }

            if(diff==0){

                diff = a.y-b.y;

            }

            return diff;
           
        }

       
    };


    public int distance(Point a) {

        return (a.x-this.origin.x)*(a.x-this.origin.x)+(a.y-this.origin.y)*(a.y-this.origin.y);
        
    }



    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here

        this.origin = origin;

        int size = points.length>k?k:points.length;

        Point[] ans = new Point[size];

        Queue<Point> queue = new PriorityQueue<Point>( PointerComparator);

        for(Point p: points){

            queue.offer(p);
        }


        for(int i=0; i<size; i++){
            
            ans[i]=queue.poll();
        }

        return ans;



    }
}