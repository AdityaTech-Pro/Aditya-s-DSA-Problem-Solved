class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int n=prices.length;
        int[] dp=new int[n];
        int buy=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(prices[i]<buy){
                buy=prices[i];
            }else{
                ans=Math.max(ans, prices[i]-buy);
            }
            dp[i]=ans;
        }
        return dp[n-1];
    }
}