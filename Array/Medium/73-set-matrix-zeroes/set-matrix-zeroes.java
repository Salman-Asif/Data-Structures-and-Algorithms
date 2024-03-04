class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstCol = false, firstRow = false;
        for(int i=0;i<matrix.length;i++) {
            if(matrix[i][0]==0)  {
                firstCol = true;
                break;
            }
        }

        for(int j=0;j<matrix[0].length;j++) {
            if(matrix[0][j]==0) {
                firstRow = true;
                break;
            }
        }

        for(int i=1; i< matrix.length; i++) {
            for(int j=1; j< matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] =0;
                    matrix[0][j] =0;
                }
            }
        }

        for(int i=1;i<matrix.length;i++) {
            for(int j=1; j< matrix[0].length;j++) {
                if(matrix[0][j]==0) {
                    for(int col=0;col<matrix.length ; col++) {
                        matrix[col][j] = 0;;
                    }
                }
                if(matrix[i][0]==0) {
                    for(int row=0;row<matrix[0].length; row++) {
                        matrix[i][row] = 0;
                    }
                }
            }
        }

        if(firstRow) {
            for(int i=0;i<matrix[0].length;i++) {
                matrix[0][i] =0;
            }
        }
        if(firstCol) {
            for(int i=0;i<matrix.length;i++) {
                matrix[i][0] = 0;
            }
        }
     }
}