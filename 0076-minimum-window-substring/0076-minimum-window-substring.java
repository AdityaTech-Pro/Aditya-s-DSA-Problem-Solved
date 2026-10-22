class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (m > n) {
            return "";
        }

        int[] freq = new int[128];

        for (int i = 0; i < m; i++) {
            freq[t.charAt(i)]++;
        }

        int start = 0;
        int count = m;
        int minLen = Integer.MAX_VALUE;
        int left = 0;

        for (int end = 0; end < n; end++) {
            char ch = s.charAt(end);

            if (freq[ch] > 0) {
                count--;
            }

            freq[ch]--;

            while (count == 0) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    left = start;
                }

                char c = s.charAt(start);
                freq[c]++;

                if (freq[c] > 0) {
                    count++;
                }

                start++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(left, left + minLen);
    }
}