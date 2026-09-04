class Solution {
    public int firstStableIndex(int[] nums, int k) {
        HashSet<Integer>set=new HashSet<>();
        int ResindexVal=Integer.MAX_VALUE;
        int Resindex=-1;
        int n=nums.length;
        int[] arr=new int[n];
        int idx=0;
        for(int i=0; i<n; i++){
            arr[idx++]=check(nums, i);
        }
        for(int i=0; i<n; i++){
            System.out.print(arr[i]);
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=k){
                return i;
                // if(set.contains(arr[i])){
                //     continue;
                // }
                // ResindexVal=Math.min(ResindexVal, ai);
                // if(ResindexVal==arr[i]){
                //     Resindex=i;
                // }
                // set.add(arr[i]);
            }
        }
        
        return Resindex;
    }
    public int check(int[] nums, int index){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0; i<=index; i++){
            max=Math.max(max,nums[i]);
        }
        for(int i=index; i<nums.length; i++){
            min=Math.min(min,nums[i]);
        }
        return max-min;
    }
}