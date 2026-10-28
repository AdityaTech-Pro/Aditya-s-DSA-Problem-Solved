class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }
        int[] ans=new int[2];
        int val=0;
        for(int i=0; i<nums.length; i++){
            val=target-nums[i];
            list.remove(i);
            if(list.contains(val)){
                ans[0]=i;
                break;
            }
            list.add(i, nums[i]);
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]==val ){
                ans[1]=i;
            }
        }
        return ans;

    }
}