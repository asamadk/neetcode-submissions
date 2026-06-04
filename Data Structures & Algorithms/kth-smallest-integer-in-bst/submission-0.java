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
    PriorityQueue<Integer> q = new PriorityQueue<>();

    public int kthSmallest(TreeNode root, int k) {
        itr(root,k);
        while (k > 1) {
            q.poll();
            k--;
        }
        return q.poll();
    }

    private void itr(TreeNode root, int k) {
        if (root == null) return;

        q.add(root.val);

        itr(root.left,k);
        itr(root.right,k);
    }
}
