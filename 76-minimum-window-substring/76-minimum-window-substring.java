class Solution {
    public String minWindow(String s, String t) {
        int windowStart =0, sLength = s.length(), tLength = t.length();
        Map<Character, Integer> tMap = new HashMap<>();
        String answer;
        int startIndex=0, endIndex=0;
        for(int i=0;i<tLength;i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        
        int min = Integer.MAX_VALUE, matched=0;
        char rightChar, leftChar ;
        
        for(int windowEnd=0; windowEnd < sLength ; windowEnd++) {
            rightChar = s.charAt(windowEnd);
            
            if(tMap.containsKey(rightChar)) {
                tMap.put(rightChar, tMap.get(rightChar)-1);
                if(tMap.get(rightChar) == 0) {
                    matched++;
                }
            }
            
            while(matched == tMap.size()) {
                if(min > windowEnd-windowStart+1) {
                    min = windowEnd-windowStart+1;
                    startIndex = windowStart;
                    endIndex = windowEnd;
                }                
            
                leftChar = s.charAt(windowStart);
                if(tMap.containsKey(leftChar)) {
                    if(tMap.get(leftChar) == 0) {
                        matched--;
                    }
                    tMap.put(leftChar, tMap.get(leftChar)+1);    
                }
                windowStart++;
            }
            
        }
        return min == Integer.MAX_VALUE? "" : s.substring(startIndex, endIndex+1); 
    }
}