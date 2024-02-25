class Solution {
    public void moveZeroes(int[] nums) {
        int zeroEleIndex = findLeftMostZeroEle(nums, 0);
        int nonZeroEleIndex = findLeftMostNonZeroEle(nums, zeroEleIndex +1);

        if(zeroEleIndex >= nums.length ||nonZeroEleIndex >= nums.length) return;

        int temp = nums[zeroEleIndex];
        while(zeroEleIndex < nonZeroEleIndex && nonZeroEleIndex < nums.length) {
            temp  = nums[zeroEleIndex];
            nums[zeroEleIndex] = nums[nonZeroEleIndex];
            nums[nonZeroEleIndex] = temp;
            zeroEleIndex = findLeftMostZeroEle(nums, zeroEleIndex+1);
            nonZeroEleIndex = findLeftMostNonZeroEle(nums, zeroEleIndex+1);
        }
    }

    private int findLeftMostZeroEle(int[] nums, int index) {
        for(int i=index; i<nums.length ; i++) {
            if(nums[i] == 0) return i;
        }
        return nums.length;
    }

    private int findLeftMostNonZeroEle(int[] nums, int index) {
        for(int i=index; i<nums.length; i++) {
            if(nums[i]!=0) return i;
        }
        return nums.length;
    }

    private int findLeftMostElement(int[] nums, int index, Predicate<Integer> predicate) {
        for(int i=index; i<nums.length; i++) {
            if(predicate.test(nums[i])) {
                return i;
            }
        }
        return nums.length;
    }
}