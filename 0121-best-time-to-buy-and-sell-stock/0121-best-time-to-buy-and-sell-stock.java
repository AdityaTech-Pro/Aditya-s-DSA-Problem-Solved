class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int buy=Integer.MAX_VALUE;
        int n=prices.length;
        int profit=0;
        for(int i=0; i<n; i++){
            if(prices[i]<buy){
                buy=prices[i];
                
            }else{
                ans=Math.max(ans, prices[i]-buy);
            }
        }
        return ans;
    }
}