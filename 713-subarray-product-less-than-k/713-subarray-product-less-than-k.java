class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Arrays.sort(nums);
       // System.out.println(nums.toString());
        int length = nums.length;
        int lastIndex = length-2;
        int low,high,count=0, product=Integer.MAX_VALUE;
        
        for(int i=0;i<length;i++) {
            product = nums[i];
            
            if(product<k) {
                count++;
            }
            else 
                continue;
            
            for(int j=i+1;j<length;j++) {
                product = product*nums[j];
                
                if(product<k) {
                    count++;
                }
                else
                    break;
            }
        }
       
        return count;
    }
}