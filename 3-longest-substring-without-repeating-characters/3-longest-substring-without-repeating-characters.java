class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowStart = 0, maxLength = 0, length = s.length();
        char ch, charLeft;
        Map<Character, Integer> charMap = new HashMap<>();
        
        for(int windowEnd = 0; windowEnd < length; windowEnd++) {
            ch = s.charAt(windowEnd);
          
            charMap.put(ch, charMap.getOrDefault(ch,0)+1);
            
               
                while(charMap.get(ch) > 1) {
                    charLeft = s.charAt(windowStart);
                    charMap.put(charLeft, charMap.get(charLeft)-1);
                    if(charMap.get(charLeft) == 0) {
                        charMap.remove(charLeft);
                    }
                    windowStart++;
                }
            
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }
}