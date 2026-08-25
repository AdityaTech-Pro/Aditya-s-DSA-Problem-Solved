class Solution {
    public int missingMultiple(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0; i<n; i++){
            max=Math.max(max,nums[i]);
        }
        
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<n; i++){
            if(nums[i]%k==0){
                set.add(nums[i]);
            }
        }
        int ans=0;
        for(int i=k; i<=max+k; i+=k){
            if(!set.contains(i)){
                ans=i;
                break;
                
            }
        }
        return ans;
    }
}