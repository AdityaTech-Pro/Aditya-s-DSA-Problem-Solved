class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;

        int min=1;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max=Math.max(max, piles[i]);
        }
    
        int ans=max;
        while(min <= max){
            int k=min + (max-min)/2;                //mid
            long hr=0;
            for(int p:piles){
                if(p%k==0){
                    hr+=p/k;
                }else{
                    hr+=(p/k)+1;
                }
                if(hr>h) break;
            }
            if(hr<=h){
                ans=k;
                max=k-1;
            }else{
                min=k+1;
            }
        }
        return ans;
    }
}