class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        Map<Character, Integer> charMapS1 = new HashMap<>();
        char ch;
        for(int i=0; i < s1.length() ; i++) {
            ch = s1.charAt(i);
            charMapS1.put(ch, charMapS1.getOrDefault(ch,0)+1);
        }
        
        int length = s2.length();
        int windowStart = 0;
        char leftChar;
        int matched =0;
        
        for(int windowEnd=0; windowEnd<length ; windowEnd++) {
            ch = s2.charAt(windowEnd);
            
            if(charMapS1.containsKey(ch)) {
                charMapS1.put(ch, charMapS1.get(ch)-1);
                if(charMapS1.get(ch) == 0) {
                    matched++;
                }
            } 
             
            if(matched == charMapS1.size()) return true;
            
            if(windowEnd >= s1.length()-1) {
                leftChar = s2.charAt(windowStart);
                if(charMapS1.containsKey(leftChar)) {
                    if(charMapS1.get(leftChar) == 0)
                        matched--;
                    charMapS1.put(leftChar, charMapS1.get(leftChar)+1);
                }
                windowStart++;
            }
            
        }
        return false;
    }
}
