class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            temp[i] = nums[i];
        }

        Arrays.sort(temp);
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<temp.length;i++) {
            if(!map.containsKey(temp[i])) {
                map.put(temp[i], i);
            }
        }


        int[] ans = new int[nums.length];
        
        for(int i=0; i<nums.length; i++) {
            ans[i] = map.get(nums[i]);
            //System.out.println("nums "+i+" "+nums[i]);
            //System.out.println(ans[i]);
        }

        return ans;
    }
}