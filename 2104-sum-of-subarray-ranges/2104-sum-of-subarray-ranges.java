// class Solution {
//     public long subArrayRanges(int[] nums) {
//         long sum=0;
//         int n=nums.length;
//         for(int i=0; i<n; i++){
//             int max=nums[i];
//             int min=nums[i];
//             for(int j=i; i<n; j++){
//                 max=Math.max(max,nums[i]);
//                 min=Math.min(min,nums[i]);
//                 sum+=max-min;
//             }
//         }
//         return sum;
//     }
// }
class Solution {

    public long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }

    // Sum of maximum values of all subarrays
    private long sumMax(int[] nums) {
        int n = nums.length;
        long sum = 0;
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? Integer.MAX_VALUE : nums[i];

            while (top >= 0 && nums[stack[top]] < curr) {
                int mid = stack[top--];

                int left = (top >= 0) ? stack[top] : -1;
                int right = i;

                sum += (long) nums[mid] * (mid - left) * (right - mid);
            }

            if (i < n) {
                stack[++top] = i;
            }
        }

        return sum;
    }

    // Sum of minimum values of all subarrays
    private long sumMin(int[] nums) {
        int n = nums.length;
        long sum = 0;
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? Integer.MIN_VALUE : nums[i];

            while (top >= 0 && nums[stack[top]] > curr) {
                int mid = stack[top--];

                int left = (top >= 0) ? stack[top] : -1;
                int right = i;

                sum += (long) nums[mid] * (mid - left) * (right - mid);
            }

            if (i < n) {
                stack[++top] = i;
            }
        }

        return sum;
    }
}