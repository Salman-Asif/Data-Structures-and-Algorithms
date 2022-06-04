class Solution {
    public int longestOnes(int[] nums, int k) {
        int windowStart=0, maxOnesAfterReplacement = 0, maxOnes=0, length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int currentElement=-1;
        
        for(int windowEnd =0; windowEnd < length ; windowEnd++) {
            
            currentElement = nums[windowEnd];
            map.put(currentElement, map.getOrDefault(currentElement,0)+1);
            
            if(currentElement == 1) {
                maxOnes = Math.max(maxOnes, map.get(currentElement));
            }
            
            if(windowEnd - windowStart +1 - maxOnes > k) {
                int leftElement = nums[windowStart];
                map.put(leftElement, map.get(leftElement)-1);
                if(map.get(leftElement) == 0) {
                    map.remove(leftElement);
                }
                windowStart++;
            }
            
            maxOnesAfterReplacement  = Math.max(maxOnesAfterReplacement, windowEnd-windowStart+1);
        }
        return maxOnesAfterReplacement;
    }
}