class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }

        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            //Example story : nums=[1,2,3] here son=3 -- dp=[1,2,x] -- dp=[grandpa, father, x] so, grandpa + son > father then x = grandpa + son other wise x = father
            dp[i]=Math.max(dp[i-1], dp[i-2] + nums[i]); 
        }
        return dp[n-1];
    }
}