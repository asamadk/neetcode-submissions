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
    class Pair {
        TreeNode node;
        Integer level;

        Pair(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        Integer max = -1;

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            if (pair.level > max) {
                max = pair.level;
            }

            if (pair.node.right != null)
                stack.push(new Pair(pair.node.right, pair.level + 1));
            if (pair.node.left != null)
                stack.push(new Pair(pair.node.left, pair.level + 1));
        }

        return max;
    }
}
