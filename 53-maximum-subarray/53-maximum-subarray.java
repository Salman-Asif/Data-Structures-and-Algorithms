class Solution {
    
    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int max=currentMax;
        int length = nums.length;
        
        for(int i=1;i<length;i++) {
            currentMax = Math.max(nums[i], nums[i]+currentMax);
            
            if(max < currentMax) {
                max = currentMax;
            }
            
        }
        return max;
        
    }
}