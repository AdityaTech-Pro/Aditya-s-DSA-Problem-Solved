class Solution {
    public int minMoves(int[] nums) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0; i<n; i++){
            max=Math.max(max, nums[i]);
        }
        int moves=0;
        for(int i=0; i<n; i++){
            if(max>nums[i]){
                moves+=max-nums[i];
            }
        }
        return moves;
    }
}