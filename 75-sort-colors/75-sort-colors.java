class Solution {
    public void sortColors(int[] nums) {
        int zeroes=0, ones=0, twos=0;
        int length = nums.length;
        int temp;
        for(int cur=0;cur<length;cur++) {
            switch(nums[cur]) {
                case 0: zeroes++;
                    break;
                case 1: ones++;
                    break;
                case 2: twos++;
            }
        }
        
        int start=0;
        while(zeroes-- > 0) {
            nums[start++] = 0;
        }
        while(ones-- > 0) {
            nums[start++] = 1;
        }
        while(twos-- > 0) {
            nums[start++] =2;
        }
        
        return ;
    }
}