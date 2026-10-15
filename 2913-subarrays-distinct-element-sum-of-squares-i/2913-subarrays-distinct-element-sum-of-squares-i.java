class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans=0;
        int n=nums.size();
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                ans+=Math.pow(check(i,j,nums), 2);
            }
        }
        return ans;
    }
    public int check(int i, int j, List<Integer> nums){
        HashSet<Integer> set=new HashSet<>();
        for(int x=i; x<=j; x++){
            set.add(nums.get(x));
        }
        return set.size();
    }
}