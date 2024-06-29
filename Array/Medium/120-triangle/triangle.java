class Solution {
    int rows;
    Map<Integer, Map<Integer, Integer>> dpMap = new HashMap<>();
    private int minTotal(int cur, int index, List<List<Integer>> triangle) {
        if(dpMap.get(cur) !=null && dpMap.get(cur).get(index) != null) {
            return dpMap.get(cur).get(index);
        }

        //if more than last row or index more than length of row, stop
        if(cur==rows || index >= triangle.get(cur).size()) {
            return 0;
        }

        //sum and go down same level
        int down = triangle.get(cur).get(index) + minTotal(cur+1, index, triangle);
        int downRight = triangle.get(cur).get(index) + minTotal(cur+1 , index+1, triangle);

        int result = Math.min(down, downRight);
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(index, result);
        dpMap.put(cur, indexMap);
        return result;
    }

    private int minTotalTable(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=0;i<rows;i++) {
            dp.add(new ArrayList<>());
        }

        dp.get(0).add(triangle.get(0).get(0));

        for(int i=1;i<rows;i++) {
            int rowSize = triangle.get(i).size();
            for(int j=0;j < rowSize; j++) {
                if(j==0) {
                    dp.get(i).add(
                        triangle.get(i).get(j) + dp.get(i-1).get(j)
                    );
                } else if (j < rowSize-1) {
                    //last element in each row wont have corresponding (i-1, j) ,handled in else
                    dp.get(i).add(
                        triangle.get(i).get(j) +
                        Math.min(dp.get(i-1).get(j) , dp.get(i-1).get(j-1))
                    );
                } else {
                    dp.get(i).add(triangle.get(i).get(j) + dp.get(i-1).get(j-1));
                }
                
            }
        }



        int minValue = Integer.MAX_VALUE;

        for(int i=0; i<triangle.get(rows-1).size(); i++) {
            minValue = Math.min(minValue, dp.get(rows-1).get(i));
        }
        
        return minValue;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        //cant use greedy since inital can be small later can be very large
        //so try all possible but we can save upto prev row sum, so dp 

        if(triangle.size() == 1 && triangle.get(0).size() == 1) return triangle.get(0).get(0);

        rows = triangle.size();
        //return minTotal(0, 0, triangle);
        return minTotalTable(triangle);
    }
}