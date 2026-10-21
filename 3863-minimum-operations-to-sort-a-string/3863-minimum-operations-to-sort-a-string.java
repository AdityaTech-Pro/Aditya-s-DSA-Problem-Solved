
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        char[] str = s.toCharArray();
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);

        String sortedS = new String(sorted);

        // Already sorted
        if (check(sortedS, s)) {
            return 0;
        }

        // Cannot sort the entire string in one operation
        if (n == 2) {
            return -1;
        }

        char min = sorted[0];
        char max = sorted[n - 1];

        // One operation is enough
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Check whether min or max is in the middle
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }

        // Otherwise, three operations are required
        return 3;
    }

    public boolean check(String sortedS, String s) {
        return sortedS.equals(s);
    }
}
