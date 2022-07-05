class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //sort array
        Arrays.sort(nums);
        
        /*
        cur,low=cur+1,high=n-1
        loop and find absDifference=Math.abs(sum-target)
         for each absDifference find min
        */
        
        int length = nums.length, lastCurIndex = length-2, low, high;
        int sum = Integer.MAX_VALUE, absDifference=Integer.MAX_VALUE, min=Integer.MAX_VALUE, ans=Integer.MAX_VALUE;
        
        for(int cur=0; cur<lastCurIndex; cur++) {
            low = cur+1;
            high = length-1;
            
            while(low<high) {
                sum = nums[cur]+nums[low]+nums[high];
                absDifference = Math.abs(sum-target);
            
                ans = min < absDifference ? ans:sum;
                min = Math.min(min, absDifference);
                
                if(sum > target) 
                    high--;
                else
                    low++;
            }
        }
        
        //return ans
        return ans;
    }
}