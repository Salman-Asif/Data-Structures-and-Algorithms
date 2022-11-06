class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        ArrayList<List<String>> answer = new ArrayList<List<String>>();
         StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++) sb.append(".");
        return nQueens(n, queens, 0, answer, sb);
    }
    
    private List<List<String>> nQueens(int n, int[] queens, int row, ArrayList<List<String>> answer, StringBuilder sb) {
        if(row == n) {
            ArrayList<String> ds = new ArrayList<>();
            for(int x: queens) {
                sb.setCharAt(x, 'Q');
                ds.add(sb.toString());
                sb.setCharAt(x, '.');
            }
            answer.add(ds);
            return answer;
        }
        
        for(int col=0; col<n; col++) {
            if(canPlace(col, row, queens)) {
                queens[row] = col;
                nQueens(n, queens, row+1, answer, sb);
            }
        }
        
        return answer;
        
    }
    
    
    private boolean canPlace(int col, int row, int[] queens) {
        for(int i=0; i< row;i++) {
            int curCol = queens[i];
            if(curCol == col) return false;
            if(Math.abs(col-curCol) == Math.abs(row-i)) return false;
        }
        return true;
    }
    
}
