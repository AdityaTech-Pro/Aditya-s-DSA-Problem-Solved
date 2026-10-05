class Solution {
    public int maxArea(int[] h) {
        int left=0;
        int right=h.length-1;
        int ans=0;
        while(left<right){
            int height=Math.min(h[left],h[right]);
            int depth=right-left;
            ans=Math.max(ans,height*depth);
            if(h[left] <= h[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}