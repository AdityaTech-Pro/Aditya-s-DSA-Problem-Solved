class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int rt = k%n;
        int[] arr=new int[n+n];
        int idx=0;
        for(int i=0; i<n; i++){
            arr[idx++]=nums[i];
        }
        for(int i=0; i<n; i++){
            arr[idx++]=nums[i];
        }
        int idx2=0;
        int first=n-rt;
        for(int i=first; i<first+n; i++){
            nums[idx2++]=arr[i];
        }
        // return nums;
    }
}