class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;

        double[] ratio = new double[n];

        for (int i = 0; i < n; i++) {
            ratio[i] = boxTypes[i][1];
        }

        double[] sr = new double[n];

        for (int i = 0; i < n; i++) {
            sr[i] = ratio[i];
        }

        Arrays.sort(sr);

        int ans = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int x = n - 1; x >= 0; x--) {

            for (int i = 0; i < n; i++) {

                if (!set.contains(i) && sr[x] == ratio[i]) {

                    set.add(i);

                    int take = Math.min(boxTypes[i][0], truckSize);

                    ans += take * boxTypes[i][1];

                    truckSize -= take;

                    break;
                }
            }

            if (truckSize == 0) {
                break;
            }
        }

        return ans;

//simple approach

        // Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        // int ans = 0;

        // for (int i = 0; i < boxTypes.length; i++) {
        //     int boxes = Math.min(boxTypes[i][0], truckSize);

        //     ans += boxes * boxTypes[i][1];
        //     truckSize -= boxes;
        //     if (truckSize == 0) {
        //         break;
        //     }
        // }

        // return ans;
    }
}