class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        
        pascal.add(Arrays.asList(1));
        
        for(int i=1;i<numRows;i++) {
            
            List<Integer> list = new ArrayList<>();
            List<Integer> prevList = pascal.get(i-1);
            
            list.add(1);
            
            for(int j=1;j<i;j++) {
                list.add(prevList.get(j)+prevList.get(j-1));
            }
            
            list.add(1);
            
            pascal.add(list);
        }
        
        return pascal;
    }
}