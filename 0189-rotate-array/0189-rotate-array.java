class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int[] rev=new int[n+n];
        int idx=0;
        for(int i=0; i<n; i++){
            rev[idx++]=nums[i];
        }
        for(int i=0; i<n; i++){
            rev[idx++]=nums[i];
        }


        int rt=k%n;
        int[] ans=new int[n];
        int idx2=0;
        for(int i=n-rt; i<n-rt+n; i++){
            ans[idx2++]=rev[i];
           //System.out.print(rev[i]);
        }
        for(int i=0; i<n; i++){
            nums[i]=ans[i];
        }
    }
}