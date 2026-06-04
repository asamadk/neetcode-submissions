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
    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return result;
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)return null;

        if (root.val > p.val && root.val > q.val) lca(root.left, p, q);
        if (root.val < p.val && root.val < q.val) lca(root.right, p, q);

        if (root.val >= p.val && root.val <= q.val) result = root;
        if (root.val <= p.val && root.val >= q.val) result = root;

        return root;
    }
}
