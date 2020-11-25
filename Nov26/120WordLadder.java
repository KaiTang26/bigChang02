class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {

        int count = 0;
        Queue<String> queue = new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        queue.offer(start);
        set.add(start);


        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int i=0; i<size; i++){
                String current_word = queue.poll();

                for(String next: neighbor(current_word, dict, end)){
                    if(next.equals(end)){
                        return count+1;
                    }
                    if(set.add(next)){
                        queue.offer(next);
                    }
                }
            }

        }


        return 0;

    }


    public List<String> neighbor(String word, Set<String> dict, String end){

        List<String> neighbors = new ArrayList<String>();

        for(int i=0; i<word.length(); i++){
            for(char c='a'; c<='z'; c++){

                if(c==word.charAt(i)){
                    continue;
                }
                String newWord = replace(word, i, c);

                if((dict.contains(newWord)|| newWord.equals(end) )){
                    neighbors.add(newWord);
                }
            }
        }


        return  neighbors;
    }

    public String replace(String s, int index, char newC){

        char[] cArray = s.toCharArray();

        cArray[index] = newC;

        return new String(cArray);

    }



}
