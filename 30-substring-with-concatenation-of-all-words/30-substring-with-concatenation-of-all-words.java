class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> wordsMap = new HashMap<>();
        for(int i=0;i<words.length;i++) {
            wordsMap.put(words[i], wordsMap.getOrDefault(words[i],0)+1);
        }
        
        int wordsCount = words.length, wordLength = words[0].length();
        
        for(int windowStart=0; windowStart <= s.length() - (wordsCount*wordLength); windowStart++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for(int j=0; j< wordsCount ; j++) {
                int wordStartIndex = windowStart + j*wordLength;
                
                String word = s.substring(wordStartIndex, wordStartIndex + wordLength);
                if(!wordsMap.containsKey(word)) {
                    break;
                }
                
                wordsSeen.put(word, wordsSeen.getOrDefault(word,0)+1);
                if(wordsSeen.get(word) > wordsMap.getOrDefault(word, 0)) {
                    break;
                }
                
                if(j+1 == wordsCount)
                    answer.add(windowStart);
                
            }
        }
        return answer;
        
    }
}