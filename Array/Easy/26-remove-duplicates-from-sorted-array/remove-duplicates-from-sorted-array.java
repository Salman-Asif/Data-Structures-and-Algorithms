class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, index=1;
        while(i< nums.length && index < nums.length) {
          index = findDistinctElementIndex(nums, i, index);
          if(index == nums.length) return i+1;
          nums[++i] = nums[index];
        }
        return nums.length;
    }

    private int findDistinctElementIndex(int[] nums, int curIndex, int distinctIndex) {
        for(int i=distinctIndex; i< nums.length;i++) {
            if(nums[curIndex] != nums[i]) return i;
        }
        return nums.length;
    }
}