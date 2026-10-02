class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int k=n/3;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key)>k){
                list.add(key);
            }
        }
        return list;
    }
}