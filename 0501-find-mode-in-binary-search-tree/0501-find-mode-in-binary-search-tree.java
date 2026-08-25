/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {

        // Store frequency
        traverse(root);

        // Find maximum frequency
        int max = 0;

        for (int value : map.values()) {
            max = Math.max(max, value);
        }

        // Count how many modes
        int count = 0;

        for (int value : map.values()) {
            if (value == max) {
                count++;
            }
        }

        // Store modes
        int[] ans = new int[count];
        int i = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                ans[i] = entry.getKey();
                i++;
            }
        }

        return ans;
    }

    void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        traverse(root.left);
        traverse(root.right);
    }
}