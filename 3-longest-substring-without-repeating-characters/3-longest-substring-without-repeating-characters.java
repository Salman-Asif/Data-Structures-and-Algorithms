class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowStart = 0, maxLength = 0, length = s.length();
        char ch, charLeft;
        Map<Character, Integer> charMap = new HashMap<>();
        
        for(int windowEnd = 0; windowEnd < length; windowEnd++) {
            ch = s.charAt(windowEnd);
            
            if(charMap.containsKey(ch) ) {
                windowStart = Math.max(windowStart, charMap.get(ch)+1);
            }            
            
            charMap.put(ch, windowEnd);
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }
}