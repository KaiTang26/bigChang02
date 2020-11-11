class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here


        Map<Integer, Integer> indegrees = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

        for(int i=0; i<prerequisites.length; i++){

            int nextCourse = prerequisites[i][0];
            int firstTakeCourse = prerequisites[i][1];

            if(!graph.containsKey(firstTakeCourse)){

                List<Integer> neighbors = new ArrayList<Integer>();
                neighbors.add(nextCourse);
                graph.put(firstTakeCourse, neighbors);

            }else{

                List<Integer> neighbors = graph.get(firstTakeCourse);
                neighbors.add(nextCourse);
                graph.put(firstTakeCourse, neighbors);


            }

            if(!indegrees.containsKey(nextCourse)){
                indegrees.put(nextCourse, 1);

            }else{
                indegrees.put(nextCourse, indegrees.get(nextCourse)+1);
            }


        }


        Queue<Integer> queue = new LinkedList<Integer>();

        int takenCourse = 0;

        for(int i =0; i<numCourses; i++){
            if(!indegrees.containsKey(i)){

                queue.offer(i);

            }
        }

        while(!queue.isEmpty()){

            int course = queue.poll();

            takenCourse++;

            if(graph.containsKey(course)){

                for(int neighbor: graph.get(course)){
                    if(indegrees.containsKey(neighbor)){
                        indegrees.put(neighbor, indegrees.get(neighbor)-1);

                        if(indegrees.get(neighbor)==0){
                            queue.offer(neighbor);
                        }
                    }else{
                        queue.offer(neighbor);
                    }
                }

            }


        }

        System.out.println(takenCourse);



        return numCourses == takenCourse;
    }
}