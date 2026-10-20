import java.util.*;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            int k = list.get(i);

            if (check(k, nums)) {
                sum += k;
            }
        }

        return sum;
    }

    public boolean check(int k, int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n + 1];
        int[] suffMin = new int[n + 1];
        int[] prefDrop = new int[n];

        // Prefix maximum
        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
        }

        // Suffix minimum
        suffMin[n] = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }

        // Count decreasing adjacent pairs
        for (int i = 1; i < n; i++) {
            prefDrop[i] = prefDrop[i - 1];

            if (nums[i - 1] > nums[i]) {
                prefDrop[i]++;
            }
        }

        // Check every block of length k
        for (int start = 0; start < n; start += k) {
            int end = start + k - 1;

            int count = prefDrop[end] - prefDrop[start];

            // Check the circular connection
            if (nums[end] > nums[start]) {
                count++;
            }

            // A block must have at most one circular descent
            if (count > 1) {
                return false;
            }

            // Previous blocks must fit before the current block
            if (prefMax[start] > suffMin[start]) {
                return false;
            }
        }

        return true;
    }
}