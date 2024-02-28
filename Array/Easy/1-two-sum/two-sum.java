class Solution {
    public int[] twoSum(int[] nums, int target) {
       int[] result = new int[2];
       Map<Integer, Integer> eleMap = new HashMap<>();
       int ele =0;
       
       for(int i=0;i <nums.length; i++) {
           ele = nums[i];
           if(eleMap.containsKey(target-ele)) {
               result[0] = i;
               result[1] = eleMap.get(target-ele);
               break;
           }
           eleMap.put(ele, i);
       }

       return result;
    }
}