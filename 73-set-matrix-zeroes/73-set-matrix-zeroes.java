/*
Use first row and first col and mark it as 0, if any element in that row/col has zero.
Note: first need to check if first row and first col already have 0 before marking starts.
In the end fill the first row and first col if they had zero in original matrix
*/
class Solution {
    public void setZeroes(int[][] matrix) {
           boolean rowHasZero = false;
        boolean colHasZero = false;
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        
        //check first row has zero already
        for(int i=0;i<rowLength;i++) {
            if(matrix[i][0]==0) {
                rowHasZero = true;
                break;
            }
        }
        
        //check first col has zero
        for(int i=0;i<colLength;i++) {
            if(matrix[0][i]==0) {
                colHasZero = true;
                break;
            }
        }
        
        
        for(int i=1;i<rowLength;i++) {
            for(int j=1;j<colLength;j++) {
                if(matrix[i][j]==0) {
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        
         for(int i=1;i<rowLength;i++) {
            for(int j=1;j<colLength;j++) {
                if(matrix[i][0]==0 || matrix[0][j]==0) {
                    matrix[i][j]=0;
                }
            }
        }
        
        if(rowHasZero) {
            for(int i=0;i<rowLength;i++) {
                matrix[i][0]=0;
            }
        }
        
        if(colHasZero) {
            for(int i=0;i<colLength;i++) {
                matrix[0][i]=0;
            }
        }
        
    }
}