class Solution {
    int rows;

    //will return the Minimum path sum for a given triangle by dynamic programming
    private int minTotalTable(List<List<Integer>> triangle) {

        int[] minPathSums = new int[rows];
        for(int i=0;i<triangle.get(rows-1).size();i++) {
            minPathSums[i] = triangle.get(rows-1).get(i);
        }

        //start last-2 row and update same dp array
        for(int i=rows-2;i>=0;i--) {
            int rowSize = triangle.get(i).size();
            //each minPathSums element stores min value upto that point. 
            for(int j=0;j < rowSize; j++) {
                    minPathSums[j] = triangle.get(i).get(j) + Math.min(minPathSums[j] , minPathSums[j+1]);
            }
        }
        
        //always minPathSums[0] since we must reach here always and we keep updating min in above loop
        return minPathSums[0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        //cant use greedy since inital can be small later can be very large
        //so try all possible but we can save upto prev row sum, so dp 

        if(triangle.size() == 1 && triangle.get(0).size() == 1) return triangle.get(0).get(0);

        rows = triangle.size();
        return minTotalTable(triangle);
    }
}