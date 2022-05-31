// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        Map<Character, Integer> charMap = new HashMap<>();
        
        int windowStart = 0, length = s.length(), maxLength = Integer.MIN_VALUE;
        
        for(int windowEnd =0; windowEnd < length; windowEnd++) {
            char ch = s.charAt(windowEnd);
            
            
            charMap.put(ch, charMap.getOrDefault(ch,0)+1);
            
            
            while(charMap.size() > k) {
               
                char windowStartCh = s.charAt(windowStart);
                charMap.put(windowStartCh, charMap.get(windowStartCh)-1);
                if(charMap.get(windowStartCh) == 0) {
                    charMap.remove(windowStartCh);
                }
                
                windowStart++;
            }
            if(charMap.size() == k) {
                maxLength = Math.max(maxLength, windowEnd-windowStart+1);
            }
        }
        
        return maxLength == Integer.MIN_VALUE ? -1: maxLength;
    }
}