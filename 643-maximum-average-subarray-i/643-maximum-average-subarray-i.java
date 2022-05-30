class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int windowStart = 0, windowSum=0, length = nums.length;
        double averageSum = -Double.MAX_VALUE, maxAverage = -Double.MAX_VALUE;
 
        for(int windowEnd = 0; windowEnd < length; windowEnd++) {
            windowSum = windowSum + nums[windowEnd];
            if(windowEnd >= k-1) {
                averageSum = (double)windowSum/k;
                windowSum = windowSum - nums[windowStart];
                windowStart++;
            }
            if(maxAverage < averageSum) {
                maxAverage = averageSum;
            }
        }
        
        return maxAverage;
    }
}