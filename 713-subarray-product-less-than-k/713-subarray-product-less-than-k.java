class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Arrays.sort(nums);
       // System.out.println(nums.toString());
        int length = nums.length;
        int lastIndex = length-2;
        int start=0,end=0,product=1, count=0;
        
        while(end<length) {
            product=product*nums[end];
            while(start<=end && product >= k) {
                product=product/(nums[start]);
                start++;
            }
            count = count + end-start+1;
            end++;
        }
        
       
        return count;
    }
}