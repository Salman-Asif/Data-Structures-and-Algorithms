class Solution {
    
    private void swap(int[] nums, int j, int index) {
        int temp = nums[j];
        nums[j] = nums[index];
        nums[index] = temp;
    }
    
    private void reverse(int[] nums, int index) {
        int halfLength = (nums.length - index)/2;
        int lastIndex = nums.length-1;
        for(int i=0;i<halfLength;i++) {
            swap(nums, index+i, lastIndex-i);
        }
    }
    
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if(length==1) return;
        int index = length-2;
        
        while(index >= 0 && nums[index] >= nums[index+1]) index--;
        
        if(index >= 0) {
            int j=length-1;
            while(nums[index] >= nums[j]) j--;
            swap(nums, j, index);
        }
        
        reverse(nums, index+1);
    }
}