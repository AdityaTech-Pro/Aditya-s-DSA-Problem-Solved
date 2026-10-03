class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int n=nums.length;
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }

        int k=set.size();
        int idx=0;
        int[] part=new int[k];
        for(int val : set){
            part[idx++]=val;
        }

        Arrays.sort(part);
        for(int i=0; i<k; i++){
            nums[i]=part[i];
        }
        for(int i=idx; i<n; i++){
            nums[idx++]=0;
        }
        return k;
    }
}