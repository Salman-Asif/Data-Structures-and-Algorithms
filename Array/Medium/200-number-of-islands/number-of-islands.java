class Solution {

    void traverse(char[][] grid, boolean[][] visited, int i , int j) {
        if(i< 0 || i >= grid.length || j<0 || j>= grid[0].length) {
            return;
        }

        if(visited[i][j]) {
            return;
        }

        if(grid[i][j] == '0') {
            visited[i][j] = true;
            return;
        }


        if(grid[i][j] == '1') {
            visited[i][j] = true;
        } 

        traverse(grid, visited, i, j-1);
        traverse(grid, visited, i, j+1);
        traverse(grid, visited, i-1, j);
        traverse(grid, visited, i+1, j);
    }


    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count =0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == '1' && visited[i][j] == false) {
                    count++;
                    traverse(grid, visited, i, j);
                } 
            }
        }

        return count;

    }
}