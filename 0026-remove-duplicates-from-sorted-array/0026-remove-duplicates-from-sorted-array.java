class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int n=nums.length;
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }

        int idx=0;
        int[] temp=new int[set.size()];
        for(int x : set){
            temp[idx++]=x;
        }
        Arrays.sort(temp);

        for(int i=0; i<n; i++){
            nums[i]=0;
        }
        for(int i=0; i<temp.length; i++){
            nums[i]=temp[i];
        }

       return temp.length;
    }
}