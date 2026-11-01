class Solution {
    public int minMoves(int[] nums) {
        int lo=Integer.MAX_VALUE;
        for(int x:nums){
            lo=Math.min(lo, x);
        }
        int moves = 0;
        for (int x : nums) moves += x - lo;
        return moves;
    }
}