class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */

    private Map<Integer, Integer> queensPosition; //row & col pair
    private Set<Integer> incDia;
    private Set<Integer> decDia;
    private int numQ;
    private List<List<String>> results;

    public List<List<String>> solveNQueens(int n) {
        // write your code here
        this.queensPosition = new HashMap<Integer, Integer>();
        this.incDia = new HashSet<Integer>();
        this.decDia = new HashSet<Integer>();
        this.numQ = n;
        this.results = new ArrayList<>();

        backTracking(0);

        return results;

    }

    public boolean isValid(int row, int col){

        int sum = row+col;
        int sub = row-col;

        if(incDia.contains(sum) || decDia.contains(sub)||queensPosition.containsKey(row)||queensPosition.containsValue(col)){
            return false;
        }
        return true;
    }

    public void add(int row, int col){
        int sum = row+col;
        int sub = row-col;

        queensPosition.put(row, col);
        incDia.add(sum);
        decDia.add(sub);

    }

    public void remove(int row, int col){
        int sum = row+col;
        int sub = row-col;
        incDia.remove(sum);
        decDia.remove(sub);
        queensPosition.remove(row,col);
    }

    public void addToResults(){
        List<String>  chessBoard = new ArrayList<String>();

        for(int row=0; row<numQ; row++){
            StringBuilder sb = new StringBuilder();
            int targetCol = queensPosition.get(row);
            for(int col=0; col<numQ; col++){
                sb.append(col == targetCol ? 'Q' : '.');
            }

            //System.out.println(sb.toString());

            chessBoard.add(sb.toString());
        }

        results.add(chessBoard);
    }

    public void backTracking(int row){

        if(queensPosition.containsKey(numQ-1)){
            addToResults();
            return;
        }

        for(int col=0; col<numQ; col++){

            if(isValid(row, col)){
                add(row, col);
                backTracking(row+1);
                remove(row, col);
            }

        }

    }
}