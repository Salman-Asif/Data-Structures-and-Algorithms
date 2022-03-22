class Solution {
    
    Set<List<Integer>> tList ;
    int length;
    
    private void p2(int [] nums, List<Integer> list, boolean[] pick) {
        
        if(list.size() == length) {
            tList.add(new ArrayList<>(list));
            return;
        }
        
        
        for(int i=0;i<length;i++) {
            
            if(!pick[i]) {
                list.add(nums[i]);
                pick[i]=true;
                p2(nums, list, pick);
                list.remove(list.size()-1);
                pick[i]=false;
            }
        }
        
        
    }
    
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        length = nums.length;
        tList = new HashSet<>();
        
        
        if(length==1) {
            return Arrays.asList(Arrays.asList(nums[0]));
        }
        
        Arrays.sort(nums);
        
        boolean[] pick = new boolean[nums.length];
        p2(nums, new ArrayList<>(), pick);
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(tList);
        
        return ans;
        
    }
}