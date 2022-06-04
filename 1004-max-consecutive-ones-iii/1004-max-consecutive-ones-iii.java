class Solution {
    public int longestOnes(int[] nums, int k) {
        int windowStart=0, maxOnesAfterReplacement = 0, maxOnes=0, length = nums.length;
        int ones=0;
        
        for(int windowEnd =0; windowEnd < length ; windowEnd++) {
            
            if(nums[windowEnd] == 1) {
                ones++;
            }
            
            while(windowEnd - windowStart +1 - ones > k) {
                if(nums[windowStart] == 1)
                    ones--;
                windowStart++;
            }
            
            maxOnesAfterReplacement  = Math.max(maxOnesAfterReplacement, windowEnd-windowStart+1);
        }
        return maxOnesAfterReplacement;
    }
}