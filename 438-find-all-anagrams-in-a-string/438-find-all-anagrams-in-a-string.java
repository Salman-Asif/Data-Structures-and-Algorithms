class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        int windowStart =0 , sLength = s.length(), pLength = p.length();
        
        Map<Character, Integer> pMap = new HashMap<>();
        for(int i=0;i<pLength;i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0)+1);
        }
        
        int matched =0;
        char rightChar, leftChar;
        
        for(int windowEnd=0; windowEnd < sLength; windowEnd++) {
            rightChar = s.charAt(windowEnd);
            
            if(pMap.containsKey(rightChar)) {
                pMap.put(rightChar, pMap.get(rightChar)-1);
                if(pMap.get(rightChar) == 0) {
                    matched++;
                }
            }
            
            if(windowEnd - windowStart +1 > pLength) {
                leftChar = s.charAt(windowStart);
                if(pMap.containsKey(leftChar)) {
                    if(pMap.get(leftChar) == 0) {
                        matched --;
                    }
                    pMap.put(leftChar, pMap.get(leftChar)+1);
                }
                windowStart++;
            }
            
            if(matched == pMap.size() && windowEnd-windowStart+1 == pLength) {
                answer.add(windowStart);
            }
        }
        
        return answer;
    }
}