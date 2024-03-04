class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, curSum = 0;
        for(int ele : nums) {
            curSum = curSum + ele;

            if(curSum > maxSum) {
                maxSum = curSum;
            }

            if(curSum < 0) {
                curSum = 0;
            }
            
        }
        return maxSum;
    }
}