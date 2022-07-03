class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int length = nums.length;
        int[] solution = new int[length];
        
        int left = 0;
        int right = length-1;
        
        for(int lastIndex= length-1; lastIndex>=0 ; lastIndex--) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                solution[lastIndex] = nums[left]*nums[left];
                left++;
            } else {
                solution[lastIndex] = nums[right]*nums[right];
                right--;
            }
        }
        
        return solution;
        
    }
}