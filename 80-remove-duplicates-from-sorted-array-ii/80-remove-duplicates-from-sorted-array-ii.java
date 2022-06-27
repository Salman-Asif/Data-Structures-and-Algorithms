class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 2, length = nums.length, cur=2;
        while(cur < length) {
            if(nums[cur] == nums[left-2]) {
                cur++;
            } else {
                nums[left++] = nums[cur];
                cur++;
            }
        }
        return left;
    }
}