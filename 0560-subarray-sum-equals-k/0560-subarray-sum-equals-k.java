class Solution {
    public int subarraySum(int[] nums, int k) {
        // int n=nums.length;
        // int[] ps=new int[n];
        // ps[0]=nums[0];
        // for(int i=1; i<n; i++){
        //     ps[i] =ps[i-1] + nums[i];
        // }

        // int count=0;
        
        // for(int i=0; i<n; i++){
        //     if(ps[i]==k){
        //         count++;
        //     }
        //     for(int j=i+1; j<n; j++){
        //         if(ps[j]-ps[i] == k && i != j){
        //             count++;
        //         }
        //     }
        // }
       
        // return count;

    //     int n=nums.length;
    //     int count=0;
    //     for(int i=0; i<n; i++){
    //         for(int j=i; j<n; j++){
    //             if(k==call(nums,i,j)){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    // public int call(int[] a, int i, int j){
    //     int sum=0;
    //     for(int k=i; k<=j; k++){
    //         sum+=a[k];
    //     }
    //     return sum;
    // }
//      
        int count=0;
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1; i<n; i++){
            prefix[i]=prefix[i-1] + nums[i];
        }

        for(int i=0; i<n; i++){
            if(prefix[i]==k){
                count++;
            }
            for(int j=i+1; j<n; j++){
                if(prefix[j]-prefix[i] == k){
                    count++;
                }
            }
        }
        return count;
    
    }
}