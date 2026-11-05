class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n=arr1.length;
        int m=arr2.length;
        int count=0;
        int c=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<m; i++){
            set.add(arr2[i]);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(Math.abs(arr1[i]-arr2[j]) > d && !set.contains(arr1[i])){
                    c++;
                }   
            }
            if(c==m){
                count++;
                //Sysyem.out.println();
            }
            c=0;
        }
        return count;
    }
}