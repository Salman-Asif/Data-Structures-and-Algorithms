class Solution {

    Predicate<Integer> isElementZero = ele -> ele==0;

    public void moveZeroes(int[] nums) {
        int zeroEleIndex = findLeftMostZeroEleIndex(nums, 0);
        int nonZeroEleIndex = findLeftMostNonZeroIndexAfterZeroIndex(nums, zeroEleIndex+1);

        if(zeroEleIndex >= nums.length ||nonZeroEleIndex >= nums.length) return;

        int temp = nums[zeroEleIndex];
        while(zeroEleIndex < nonZeroEleIndex && nonZeroEleIndex < nums.length) {
            temp  = nums[zeroEleIndex];
            nums[zeroEleIndex] = nums[nonZeroEleIndex];
            nums[nonZeroEleIndex] = temp;
            zeroEleIndex = findLeftMostZeroEleIndex(nums, zeroEleIndex+1);
            nonZeroEleIndex = findLeftMostNonZeroIndexAfterZeroIndex(nums, zeroEleIndex+1);
        }
    }

    private int findLeftMostZeroEleIndex(int[] nums, int index) {
        return findLeftMostElement(nums, index, isElementZero);
    }

    private int findLeftMostNonZeroIndexAfterZeroIndex(int[] nums, int index) {
       return findLeftMostElement(nums, index, Predicate.not(isElementZero));
    }

    private int findLeftMostElement(int[] nums, int index, Predicate<Integer> predicate) {
        return IntStream.range(index, nums.length)
        .filter(i -> predicate.test(nums[i]))
        .findFirst()
        .orElse(nums.length);
    }
}