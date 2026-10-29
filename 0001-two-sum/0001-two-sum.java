class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        HashMap<Integer, Integer> map=new HashMap<>();

        while(i<=j){

            int remain=target-nums[i];
            if(map.containsKey(remain)){
                return new int[] {map.get(remain), i};
            }else{
                map.put(nums[i], i);
            }
//similar thing from right side 
            remain=target-nums[j];
            if(map.containsKey(remain)){
                return new int[] {j, map.get(remain)};
            }else{
                map.put(nums[j], j);
            }
            i++;
            j--;
        }
    return null;
    }
}