class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0,right=0;
        int length = nums.length;
        while(right < length) {
            if(nums[left] == nums[right]) {
                right++;
            } else {
                left++;
                nums[left] = nums[right];
            }
        }
        return left+1;
    }
}