class Solution {
    
    int maxProfit;
    int currentMin;
    
    public int maxProfit(int[] prices) {
        currentMin = prices[0];
        if(prices.length == 1) return 0;
        
        int currentPrice;
        int currentDifference;
        
        for(int i=1;i<prices.length;i++) {
            currentPrice = prices[i];
            currentDifference = currentPrice - currentMin;
            if(maxProfit < currentDifference) {
                maxProfit = currentDifference;
            }
            
            if(currentMin > prices[i]) {
                currentMin = prices[i];
            }
            
        }
        
        return maxProfit;
        
        
    }
}