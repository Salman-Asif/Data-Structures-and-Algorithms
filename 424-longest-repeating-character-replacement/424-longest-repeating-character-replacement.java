class Solution {
    public int characterReplacement(String s, int k) {
        int windowStart=0, length = s.length();
        Map<Character,Integer> charMap = new HashMap<>();
        int maxChar=0, maxLength =0;
        
        for(int windowEnd=0;windowEnd<length;windowEnd++) {
            char ch = s.charAt(windowEnd);
            charMap.put(ch, charMap.getOrDefault(ch,0)+1);
            maxChar = Math.max(maxChar, charMap.get(ch));
            
            if(windowEnd - windowStart +1 - maxChar > k) {
                char leftChar = s.charAt(windowStart);
                charMap.put(leftChar, charMap.get(leftChar)-1);
                if(charMap.get(leftChar) == 0) charMap.remove(leftChar);
                windowStart++;
            }
            
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}