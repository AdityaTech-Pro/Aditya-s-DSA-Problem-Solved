class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int maxval=0;
        int ans=0;
        for(int key : map.keySet()){
            maxval=Math.max(maxval,map.get(key));
            if(maxval==map.get(key)){
                ans=key;
            }
        }
        return ans;
    }
}