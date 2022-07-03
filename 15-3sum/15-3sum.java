class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        int lastIndexPossible = nums.length-3;
        int lastIndex = nums.length-1;
        int left=0, right=0, currentIndex=0;
        
       //[-4-4-4,-1,-1,0,1,2,3]
        
        List<List<Integer>> solution = new ArrayList<>();
    while(currentIndex <= lastIndexPossible) {
            
        if(currentIndex==0 || (currentIndex>0 && nums[currentIndex] != nums[currentIndex-1])) {
            left = currentIndex+1;
            
            right = lastIndex;
            
            // while(left < right && nums[left] == nums[left+1])
            //     left++;
            // while(right > left && nums[right] == nums[right-1] )
            //     right--;
            
           // System.out.println("left: "+left+ "right "+right);
            while(right > left) {
                
            int sum = nums[currentIndex] + nums[left]+nums[right]; 
            if( sum == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[currentIndex]);
                list.add(nums[left]);
                list.add(nums[right]);
                solution.add(list);
                
                while(left < right && nums[left] == nums[left+1])
                    left++;
                left++;
                
                while(right > left && nums[right] == nums[right-1] )
                right--;
                    right--;
            } else if(sum > 0) {
                while(right > left && nums[right] == nums[right-1] )
                    right--;
                right--;
            } else {
                while(left < right && nums[left] == nums[left+1])
                    left++;
                left++;
            }
                
            }
            
            
        }
            currentIndex++;
        }
        
        return solution;
    }
}