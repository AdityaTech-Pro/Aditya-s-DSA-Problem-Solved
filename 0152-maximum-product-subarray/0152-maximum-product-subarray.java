class Solution {
    public int maxProduct(int[] nums) {
        int ans=nums[0];
        int maxpro=nums[0];
        int minpro=nums[0];
        int n=nums.length;
        for(int i=1; i<n; i++){
            int val=nums[i];
            if(val<0){
                int temp=maxpro;
                maxpro=minpro;
                minpro=temp;
            }
            maxpro=Math.max(val, maxpro*val);
            minpro=Math.min(val, minpro*val);
            ans=Math.max(ans, maxpro);
        }
        return ans;
    }
}