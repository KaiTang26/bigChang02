class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here

        List<List<String >> results = new ArrayList<>();

        WordMap workMap = createWordMap(start, end, dict);

        List<String> subSet = new ArrayList<>();
        subSet.add(start);

        Set<String> set = new HashSet<>();
        set.add(start);

        dfs(start, workMap.neighbors, workMap.wordsToend, subSet, results, set);

        return results;


    }

    public void dfs(String first, Map<String, Set<String>> neighbors, Map<String, Integer> wordsToend, List<String> subSet, List<List<String >> results, Set<String> set){


        int currentDistance = wordsToend.get(first);
        if(currentDistance==0){
            results.add(new ArrayList(subSet));
            return;
        }


        for(String s : neighbors.get(first)){

            int nextDistance = wordsToend.get(s);
            if(nextDistance<currentDistance && set.add(s)) {
                subSet.add(s);
                dfs(s, neighbors, wordsToend, subSet, results, set);
                subSet.remove(subSet.size()-1);
                set.remove(s);
            }
        }

    }

    public WordMap createWordMap(String start, String end, Set<String> dict){
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> wordsToend = new HashMap<>();
        queue.offer(end);
        int count=0;
        wordsToend.put(end, count);

        Map<String, Set<String>> neighbors = createNeighbors(start, end, dict);

        while (!queue.isEmpty()){
            int size = queue.size();
            count++;

            for(int i=0; i<size; i++){

                String s = queue.poll();

                for(String n: neighbors.get(s)){

                    if(!wordsToend.containsKey(n)){
                        wordsToend.put(n, count);
                        queue.offer(n);
                    }
                }
            }

        }


        WordMap workMap = new WordMap();
        workMap.wordsToend = wordsToend;
        workMap.neighbors = neighbors;

        return workMap;
    }

    public Map<String, Set<String>> createNeighbors(String start, String end, Set<String> dict){

        Set<String> newDict = new HashSet<>();
        newDict.addAll(dict);
        newDict.add(start);
        newDict.add(end);
        Map<String, Set<String>> map = new HashMap<>();

        for(String s : newDict){
            Set<String> neighbors = new HashSet<>();

            for(int i=0; i<s.length(); i++){
                for(char c='a'; c<='z'; c++){
                    if(c==s.charAt(i)){
                        continue;
                    }
                    String newWord = replace(s, i, c);

                    if(!newWord.equals(s)&& newDict.contains(newWord)){
                        neighbors.add(newWord);
                    }



                }
            }

            map.put(s, neighbors);
        }

        return map;
    }

    private String replace(String old, int index, char c){

        char[] chars = old.toCharArray();
        chars[index]=c;

        return new String(chars);
    }
}


class WordMap{

    Map<String, Integer> wordsToend;
    Map<String, Set<String>> neighbors;


    WordMap(){
        wordsToend = new HashMap<>();
        neighbors = new HashMap<>();

    }
}