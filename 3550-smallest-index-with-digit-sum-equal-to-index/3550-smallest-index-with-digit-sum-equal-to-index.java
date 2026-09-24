class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        int ans=-1;
        for(int i=0; i<n; i++){
            if(check(i,nums[i])){
                ans=i;
                break;
            }
        }
        return ans;
    }
    public boolean check(int idx, int val){
        int sum=0;
        boolean res=false;
        while(val>0){
            sum+=val%10;
            val/=10;
        }
        if(sum==idx){
            res = true;
        }
        return res;
    }
}