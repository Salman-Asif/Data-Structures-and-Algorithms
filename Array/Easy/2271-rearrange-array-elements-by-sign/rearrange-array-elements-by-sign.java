class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length/2];
        int posIndex =0,  negIndex =0;
        int[] neg = new int[nums.length/2];
        for(int ele : nums) {
            if(ele>0) {
                pos[posIndex++] = ele;
            } else {
                neg[negIndex++] = ele;
            }
        }


        for(int i=0; i< nums.length/2; i++) {
            
                nums[2*i] = pos[i];
                nums[2*i+1] = neg[i];
            
        }
        return nums;
    }
}