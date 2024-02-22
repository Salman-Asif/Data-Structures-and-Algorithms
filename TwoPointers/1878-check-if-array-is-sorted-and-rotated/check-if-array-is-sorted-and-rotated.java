class Solution {
    public boolean check(int[] nums) {
        
        boolean isDecreasing=true, isIncreasing=true, edgeCase=true;
        for(int i=0;i<nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                System.out.println(i);
                isDecreasing = checkIfDecreasing(nums, i);
                System.out.println("isDecreasing "+ isDecreasing);
                isIncreasing = checkIfIncreasing(nums, i+1);
                System.out.println("isIncreasing "+ isIncreasing);
                edgeCase = nums[nums.length-1] <= nums[0] ? true: false;
            }
        }

        return isDecreasing && isIncreasing && edgeCase;
    }

    private boolean checkIfDecreasing(int[] nums, int index) {
        for(int i=index;i>0;i--) {
            if(nums[i] < nums[i-1]) return false;
        }
        return true;
    }

    private boolean checkIfIncreasing(int[] nums, int index) {
        for(int i=index; i<nums.length-1; i++ ) {
            if(nums[i] > nums[i+1]) return false;
        }
        return true;
    }
}