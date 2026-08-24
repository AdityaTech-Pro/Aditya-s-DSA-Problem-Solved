class Solution {
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        int[] PrefixSum=new int[n];
        PrefixSum[0]=stones[0];
        int idx=0;
        for(int i=1; i<n; i++){
            PrefixSum[i] = PrefixSum[i-1] + stones[i];
        }
        int ans=PrefixSum[n-1];
        for(int i=n-2; i>0; i--){
            int AliceScore=PrefixSum[i];
            ans=Math.max(ans, AliceScore - ans);
        }
        return ans;
    }
}