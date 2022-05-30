// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        
        int windowStart = 0;
        long windowSum = 0,  maxSubArraySum = Integer.MIN_VALUE;;
        int length = Arr.size();
        
        for(int windowEnd = 0; windowEnd < N; windowEnd++) {
            windowSum = windowSum + Arr.get(windowEnd);
            if(windowEnd >= K-1) {
                if(maxSubArraySum < windowSum) {
                    maxSubArraySum = windowSum;
                }
                windowSum = windowSum - Arr.get(windowStart);
                windowStart++;
            }
        }
        return maxSubArraySum;
        
    }
}