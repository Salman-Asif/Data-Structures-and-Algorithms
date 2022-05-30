class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowStart = 0, minLength = Integer.MAX_VALUE, length = nums.length;
        long windowSum = 0;
        
        for(int windowEnd = 0; windowEnd < length ; windowEnd ++) {
            windowSum  = windowSum + nums[windowEnd];
            while(windowSum >= target) {
                minLength = Math.min(minLength, windowEnd-windowStart+1);
                windowSum = windowSum - nums[windowStart];
                windowStart++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? 0:minLength;
        
    }
}