class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans=new int[nums1.length + nums2.length];
        int idx1=0;
        int idx2=0;
        int idx=0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<m; i++){
            list.add(nums1[i]);
        }
        for(int i=0; i<n; i++){
            list.add(nums2[i]);
        }
        Collections.sort(list);
        for(int i=0; i<nums1.length; i++){
            nums1[i]=list.get(i);
        }
        
    }
}