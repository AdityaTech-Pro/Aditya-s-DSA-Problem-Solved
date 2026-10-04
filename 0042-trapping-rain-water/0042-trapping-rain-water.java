class Solution {
    public int trap(int[] h) {
        int n=h.length;
        int[] pre=new int[n];
        pre[0]=h[0];
        for(int i=1; i<n; i++){
            pre[i]=Math.max(pre[i-1], h[i]);
        }

        int[] suf=new int[n];
        suf[n-1]=h[n-1];
        for(int i=n-2; i>=0; i--){
            suf[i]=Math.max(suf[i+1], h[i]);
        }
        int ans=0;
        for(int i=0; i<n; i++){
            int val=Math.min(pre[i], suf[i])-h[i];
            ans+=val;
        }
        return ans;
    }
}