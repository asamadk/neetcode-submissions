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
        TreeNode n;
        Integer m;

        Pair(TreeNode n, Integer m) {
            this.n = n;
            this.m = m;
        }
    }

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, root.val));
        int max = 0;

        while(!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode cur = pair.n;

            if (cur.val >= pair.m) max++;

            int greater = Math.max(cur.val, pair.m);
            if (cur.right != null) stack.push(new Pair(cur.right,greater));
            if (cur.left != null) stack.push(new Pair(cur.left,greater));
        }
        
        return max;
    }

    // private int getMax(Pair pair) {
    //     if (pair.n == null) return 0;

    //     TreeNode cur = pair.n;
    //     int greater = Math.max(cur.val, pair.m);
    //     if (cur.val > pair.m) this.max++;
        
    //     getMax(new Pair(cur.left, greater));
    //     getMax(new Pair(cur.right, greater));

    //     return 0;
    // }
}
