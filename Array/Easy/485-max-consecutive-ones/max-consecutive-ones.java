class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0, curOnes = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 1) {
                curOnes++;
                maxOnes = Math.max(maxOnes, curOnes);
            } else {
                curOnes = 0;
            }
        }
        return maxOnes;
    }
}