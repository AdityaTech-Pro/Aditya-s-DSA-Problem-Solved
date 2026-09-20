class Solution {
    public int trap(int[] height) {
        int pre[]=new int [height.length];
        int suff[]=new int [height.length];
        pre[0]=height[0];
        for(int i=1; i<height.length; i++){
            pre[i]=Math.max(height[i],pre[i-1]);
        }
        suff[height.length-1]=height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            suff[i]=Math.max(height[i],suff[i+1]);
        }
        int ans=0;
        for(int i=0;i<height.length;i++){
            int val=Math.min(pre[i],suff[i])-height[i];
            ans +=val;
        }
        return ans;
    }
       // return sol(height);
    // public static int sol(int arr[]){
    //     int pre[]=new int [arr.length];
    //     int suff[]=new int [arr.length];
    //     pre[0]=arr[0];
    //     for(int i=1; i<arr.length; i++){
    //         pre[i]=Math.max(arr[i],pre[i-1]);
    //     }
    //     suff[arr.length-1]=arr[arr.length-1];
    //     for(int i=arr.length-2; i>=0; i--){
    //         suff[i]=Math.max(arr[i],suff[i+1]);
    //         }
    //         int ans=0;
    //         for(int i=0;i<arr.length;i++){
    //             int val=Math.min(pre[i],suff[i])-arr[i];
    //             ans +=val;
    //         }
    //     return ans;
    //}
}