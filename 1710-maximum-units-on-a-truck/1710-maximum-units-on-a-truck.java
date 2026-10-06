class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // int n=boxTypes.length;
        // double[] ratio=new double[n];  //ratioOfUnitsAndboxes
        // for(int i=0; i<n; i++){
        //     ratio[i]=(double)(boxTypes[i][1] / boxTypes[i][0]);
        // }
        // double[] sr=new double[n]; //sr:shortedratio
        // for(int i=0; i<n; i++){
        //     sr[i]=ratio[i];
        // }
        // Arrays.sort(sr);
        // int ans=0;
        // HashSet<Integer> set=new HashSet<>();
        // for(int x=0; x<n; x++){
        //     for(int i=0; i<n; i++){
        //         if(!set.contains(i) && sr[x]==ratio[i]){
        //             set.add(i);
        //             if(boxTypes[i][0]<=truckSize){
        //                 ans+=boxTypes[i][0] * boxTypes[i][1];
        //                 truckSize-=boxTypes[i][0];
        //             }else{
        //                 ans+= boxTypes[i][1] * (truckSize / boxTypes[i][0]);
        //                 truckSize=0;
        //             }
        //         }
        //     }
        // }
        // return ans;

//simple approach

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            int boxes = Math.min(boxTypes[i][0], truckSize);

            ans += boxes * boxTypes[i][1];
            truckSize -= boxes;
            if (truckSize == 0) {
                break;
            }
        }

        return ans;
    }
}