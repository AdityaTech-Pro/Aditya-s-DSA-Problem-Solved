
import java.util.*;

class Solution {

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;
        if (n == 0) return -1;

        // Coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] a = new int[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = Arrays.binarySearch(sorted, nums[i]) + 1;
        }

        a[n] = 0; // Unique sentinel

        // Build suffix array
        int N = n + 1;

        int[] p = new int[N];
        int[] c = new int[N];
        int[] cnt = new int[N];

        for (int x : a) cnt[x]++;

        for (int i = 1; i < N; i++) {
            cnt[i] += cnt[i - 1];
        }

        for (int i = N - 1; i >= 0; i--) {
            p[--cnt[a[i]]] = i;
        }

        c[p[0]] = 0;
        int classes = 1;

        for (int i = 1; i < N; i++) {
            if (a[p[i]] != a[p[i - 1]]) {
                classes++;
            }
            c[p[i]] = classes - 1;
        }

        int[] pn = new int[N];
        int[] cn = new int[N];

        for (int len = 1; len < N; len *= 2) {

            for (int i = 0; i < N; i++) {
                pn[i] = p[i] - len;
                if (pn[i] < 0) pn[i] += N;
            }

            Arrays.fill(cnt, 0);

            for (int x : pn) {
                cnt[c[x]]++;
            }

            for (int i = 1; i < classes; i++) {
                cnt[i] += cnt[i - 1];
            }

            for (int i = N - 1; i >= 0; i--) {
                int x = pn[i];
                p[--cnt[c[x]]] = x;
            }

            cn[p[0]] = 0;
            int newClasses = 1;

            for (int i = 1; i < N; i++) {

                int cur = p[i];
                int prev = p[i - 1];

                int mid = (cur + len) % N;
                int midPrev = (prev + len) % N;

                if (c[cur] != c[prev] ||
                    c[mid] != c[midPrev]) {
                    newClasses++;
                }

                cn[cur] = newClasses - 1;
            }

            int[] temp = c;
            c = cn;
            cn = temp;

            classes = newClasses;

            if (classes == N) break;
        }

        // Remove sentinel suffix
        int[] sa = new int[n];

        for (int i = 1; i < N; i++) {
            sa[i - 1] = p[i];
        }

        // Build rank array
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }

        // Kasai's LCP algorithm
        int[] lcp = new int[n];
        int k = 0;

        for (int i = 0; i < n; i++) {

            int r = rank[i];

            if (r == 0) continue;

            int j = sa[r - 1];

            while (i + k < n &&
                   j + k < n &&
                   nums[i + k] == nums[j + k]) {
                k++;
            }

            lcp[r] = k;

            if (k > 0) k--;
        }

        // Find smallest unique subarray
        int ans = Integer.MAX_VALUE;

        for (int r = 0; r < n; r++) {

            int left = lcp[r];

            int right = (r + 1 < n) ? lcp[r + 1] : 0;

            int len = Math.max(left, right) + 1;

            if (len <= n - sa[r]) {
                ans = Math.min(ans, len);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
