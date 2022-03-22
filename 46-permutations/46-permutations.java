class Solution {
    
    List<List<Integer>> tList ;
    int length;
    
    private void p(int[] nums, List<Integer> list, boolean[] pick) {
        
        if(list.size() == length) {
            tList.add(new ArrayList<>(list));
            return;
        }
        
        
        for(int i=0;i<length;i++) {
            
            if(!pick[i]) {
                list.add(nums[i]);
                pick[i]=true;
            
                p(nums, list, pick);
                
                list.remove(list.size()-1);
                pick[i] = false;
            }   
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        tList = new ArrayList<>();
        length = nums.length;
        
        if(length == 1) {
            tList.add(Arrays.asList(nums[0]));
            return tList;
        }
        
        boolean [] pick = new boolean[length];
        Arrays.fill(pick,false);
        
        p(nums, new ArrayList<>(), pick);
        
        return tList;
        
        
    }
}