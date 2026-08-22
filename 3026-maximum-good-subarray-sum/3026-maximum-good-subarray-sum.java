class Solution {

    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Long, Long> map = new HashMap<>();

        long prefix = 0;
        long ans = Long.MIN_VALUE;

        for (int x : nums) {

            // Check x - k
            if (map.containsKey((long) x - k)) {
                ans = Math.max(ans, prefix - map.get((long) x - k) + x);
            }

            // Check x + k
            if (map.containsKey((long) x + k)) {
                ans = Math.max(ans, prefix - map.get((long) x + k) + x);
            }

            // Store minimum prefix sum for value x
            long value = map.getOrDefault((long) x, Long.MAX_VALUE);

            map.put((long) x, Math.min(value, prefix));

            prefix += x;
        }

        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}