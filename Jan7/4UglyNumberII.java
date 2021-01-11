import java.util.Queue;

public class Solution {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here

        Queue<Long> queue = new PriorityQueue<Long>();
        Set<Long> set = new HashSet<Long>();

        Long[] primes = new Long[]{Long.valueOf(2),Long.valueOf(3),Long.valueOf(5)};

        for(int i=0; i<3; i++){
            queue.add(primes[i]);
            set.add(primes[i]);
        }

        Long number = Long.valueOf(1);

        for(int i=1; i<n; i++){

            number = queue.poll(); // get min

            for(int j=0; j<3; j++){

                if(set.add(number*primes[j])){
                    queue.add(number*primes[j]);
                }

            }

        }

        return number.intValue();




    }
}