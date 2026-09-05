//TC : O(n^2)

// class Solution {
//     public int firstStableIndex(int[] nums, int k) {
//         int ResindexVal=Integer.MAX_VALUE;
//         int Resindex=-1;
//         int n=nums.length;
//         int[] arr=new int[n];
//         int idx=0;
//         for(int i=0; i<n; i++){
//             int max = Arrays.stream(nums, 0, i + 1).max().getAsInt();
//             int min = Arrays.stream(nums, i, n).min().getAsInt();
//             arr[idx++]=max-min;
//         }
//         for(int i=0; i<arr.length; i++){
//             if(arr[i]<=k){
//                 Resindex=i;
//                 break;
//             }
//         }     
//         return Resindex;
//     }
// }


//TC : O(n)

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int Resindex=-1;
        int n=nums.length;
        int idx=0;
        int[] arr=new int[n];

        int[] prifixmax=new int[n];
        int[] sufixmin=new int[n];

        prifixmax[0]=nums[0];
        for(int i=1; i<n; i++){
            prifixmax[i]=Math.max(prifixmax[i-1],nums[i]);
        }
        //similarly for sufixmin but this time for Minimum
        sufixmin[n-1]=nums[n-1];
        for(int i=n-2; i>=0; i--){
            sufixmin[i]=Math.min(sufixmin[i+1], nums[i]);
        }

        for(int i=0; i<n; i++){
            arr[idx++]=prifixmax[i] - sufixmin[i];
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=k){
                Resindex=i;
                break;
            }
        }
        
        return Resindex;
    }
}

