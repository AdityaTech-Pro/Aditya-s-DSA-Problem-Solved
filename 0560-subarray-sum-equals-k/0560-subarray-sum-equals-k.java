class Solution {
    public int subarraySum(int[] nums, int k) {
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