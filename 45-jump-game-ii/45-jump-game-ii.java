class Solution {
    public int jump(int[] nums) {
        
        int length = nums.length;
        
        if(length == 1) return 0;
        
        int end =0;
        int farthest = 0;
        int step=0;
        for(int i=0;i<length-1;i++) {
            farthest = Math.max(farthest, nums[i] +i);
            
            if(end==i) {
                end = farthest;
                step++;
            }
            
            if(end > length-1) return step;
            
        }
        

        return step;
        
    }
}