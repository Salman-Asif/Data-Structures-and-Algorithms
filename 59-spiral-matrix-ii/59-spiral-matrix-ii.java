class Solution {
    public int[][] generateMatrix(int n) {
        
        int rowStart=0, rowEnd=n-1, colStart=0, colEnd=n-1, val=1;
        int[][] matrix = new int[n][n];
        while(rowStart<=rowEnd && colStart<=colEnd) {
            
            for(int i=colStart;i<=colEnd;i++) {
                matrix[rowStart][i] = val++;
            }
            rowStart++;
            
            for(int i=rowStart;i<=rowEnd;i++) {
                matrix[i][colEnd] = val++;
            }
            
            colEnd--;
            
            for(int i=colEnd;i>=colStart;i--) {
                matrix[rowEnd][i] = val++;
            }
            
            rowEnd--;
            
            for(int i=rowEnd;i>=rowStart;i--) {
                matrix[i][colStart] = val++;
            }
            
            colStart++;
            
        }
        
        return matrix;
    }
}