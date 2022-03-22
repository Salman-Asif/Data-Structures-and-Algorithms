class Solution {
    
    List<List<Integer>> tList ;
    int length;
    
    private void p(int[] nums, List<Integer> list, int[] pick) {
        
        if(list.size() == length) {
            tList.add(new ArrayList<>(list));
            return;
        }
        
        
        for(int i=0;i<length;i++) {
            
            if(pick[i]!=1) {
                list.add(nums[i]);
                pick[i]=1;
            
                p(nums, list, pick);
                
                list.remove(list.size()-1);
                pick[i] = -1;
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
        
        int [] pick = new int[length];
        Arrays.fill(pick,-1);
        
        p(nums, new ArrayList<>(), pick);
        
        return tList;
        
        
    }
}