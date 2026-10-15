class Solution {
    public int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE;
        int cs=0;
        int n=nums.length;
        for(int i=0; i<n; i++){
            cs=Math.max(nums[i], cs+nums[i]);
            if(cs > sum){
                sum=cs;
            }
            if(cs<0){
                cs=0;
            }
        }
        return sum;
    }
}