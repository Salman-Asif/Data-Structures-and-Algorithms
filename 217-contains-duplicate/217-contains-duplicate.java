class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        if(nums.length < 2) return false;
        
        Arrays.sort(nums);
        for(int curIndex=1; curIndex< nums.length;curIndex++) {
            if(nums[curIndex] == nums[curIndex-1])
                return true;
        }
        
        return false;
    }
}