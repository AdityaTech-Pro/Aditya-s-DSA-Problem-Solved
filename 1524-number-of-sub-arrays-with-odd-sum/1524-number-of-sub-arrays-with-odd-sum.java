
class Solution {
    public int numOfSubarrays(int[] nums) {
        int even = 1;
        int odd = 0;
        int sum = 0;
        int count = 0;
        int mod = 1000000007;

        for (int num : nums) {
            sum += num;

            if (sum % 2 == 0) {
                count = (count + odd) % mod;
                even++;
            } else {
                count = (count + even) % mod;
                odd++;
            }
        }

        return count;
    }
}
