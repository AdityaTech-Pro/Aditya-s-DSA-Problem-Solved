class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] freq = new int[100001];
        int maxDiff = 0;
        long k = (long) k1 + k2;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
            maxDiff = Math.max(maxDiff, diff);
        }

        for (int i = maxDiff; i > 0 && k > 0; i--) {
            int count = freq[i];
            int moves = (int) Math.min(k, count);

            freq[i] -= moves;
            freq[i - 1] += moves;
            k -= moves;
        }

        long ans = 0;

        for (int i = 1; i < freq.length; i++) {
            ans += (long) freq[i] * i * i;
        }

        return ans;
    }
}