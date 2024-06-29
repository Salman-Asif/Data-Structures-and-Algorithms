class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int rowSize = matrix[0].length;

        for(int i=1 ; i < rows ; i++) {
            for(int j=0 ; j < rowSize ; j++) {
                if(j==0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                } else if(j == rowSize-1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                } else {
                    matrix[i][j] = matrix[i][j] + Math.min(
                        matrix[i-1][j], 
                        Math.min(matrix[i-1][j-1], matrix[i-1][j+1])
                    );
                }
            }
        }

        int minValue = Integer.MAX_VALUE;
        for(int i=0;i<rowSize;i++) {
            minValue = Math.min(minValue, matrix[rows-1][i]);
        }
        return minValue;
    }
}