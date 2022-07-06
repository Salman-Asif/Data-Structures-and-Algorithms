class Solution {
    
    public List<List<Integer>> threeSum(int[] nums, int target, int index) {
        
        int length = nums.length;
        int low , high;
        long sum = 0;
      //  System.out.println("index "+index);
        List<List<Integer>> ans = new ArrayList<>();
        for(int cur=index+1; cur<length; cur++) {
            low = cur+1;
            high = length-1;
            
            if(cur==index+1 || (cur>index+1 && nums[cur]!=nums[cur-1])) {
                
                while(low<high) {
                    sum = (long)nums[index] + (long)nums[cur] + (long)nums[low] + (long)nums[high];
                 //   System.out.println("sum "+sum);
                    if(target == sum) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[index]);list.add(nums[cur]);list.add(nums[low]);list.add(nums[high]);
                        ans.add(list);
                        
                      // System.out.println(ans.toString());
                        
                        while(low<high && nums[low]==nums[low+1]) low++;
                        low++;
                        while(low<high && nums[high]==nums[high-1]) high--;
                        high--;
                     } else if(sum<target) {
                        while(low<high && nums[low]==nums[low+1]) low++;
                        low++;
                    } else {
                        while(low<high && nums[high]==nums[high-1]) high--;
                        high--;
                        }
                    } 
                }
            }
        
         return ans;
        }
    
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> finalAnswer = new ArrayList<>();
            
        for(int i=0;i<length-3;i++) {
            if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
                List<List<Integer>> solution = new ArrayList<>();
                solution = threeSum(nums,target, i);
                finalAnswer.addAll(solution);
            }
        }
        return finalAnswer;
    }

}

 
