class Solution {
    public boolean canPartition(int[] nums) {
        int totalsum=0;
        int n=nums.length;
        for(int i=0; i<n; i++){
            totalsum+=nums[i];
        }
        if(totalsum%2!=0){
            return false;
        }
        int target=totalsum/2;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for(int num : nums){
            for(int j=target; j>=num; j--){
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}