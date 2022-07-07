class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int start = 0, end= length-1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        while(start < length-1 && nums[start] <= nums[start+1]) {
            start++;
        }

     //   System.out.println("start "+start);
        
        if(start == length-1) return 0;
        
        while(end > 0 && nums[end-1] <= nums[end]) {
            end--;
        }
        
     //   System.out.println("end "+end);
        
        for(int cur=start; cur <= end ; cur++) {
            max = Math.max(nums[cur], max);
            min = Math.min(nums[cur], min);
        } 
        
      //  System.out.println("max "+max+" min "+min);
        
        while(start > 0 && nums[start-1] > min) {
           start--;
        }
        
        while(end < length-1 && nums[end+1] < max) {
            end++;
        }
        
      //  System.out.println("start "+start+" end "+end);
        return end-start+1;
        
    }
}