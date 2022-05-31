class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int windowStart =0, length = fruits.length, fruit, maxLength = Integer.MIN_VALUE;
        
        for(int windowEnd =0; windowEnd < length; windowEnd++) {
            fruit = fruits[windowEnd];
            map.put(fruit, map.getOrDefault(fruit,0)+1);
            
            while(map.size()>2) {
                map.put(fruits[windowStart], map.get(fruits[windowStart])-1);
                if(map.get(fruits[windowStart]) == 0) {
                    map.remove(fruits[windowStart]);
                }
                windowStart++;
            }
            
                maxLength = Math.max(maxLength, windowEnd - windowStart +1);
            
        }
            
            return maxLength;
        }
    }
