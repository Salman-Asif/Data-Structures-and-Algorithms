class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, curSum = 0;
        for(int ele : nums) {
            if(curSum + ele > ele) {
                maxSum = Math.max(maxSum, curSum+ele);
                curSum = curSum + ele;
            } else {
                maxSum = Math.max(maxSum, ele);
                curSum = ele;
            }
            
        }
        return maxSum;
    }
}