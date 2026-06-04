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

class Pair {
    TreeNode node;
    Integer level;

    Pair(TreeNode node, Integer level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<Pair> deck = new ArrayDeque<>();
        deck.offerLast(new Pair(root,1));
        
        Set<Integer> visited = new HashSet<>();
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;

        while (!deck.isEmpty()) {
            Pair pair = deck.pollFirst();
            TreeNode cur = pair.node;

            if (!visited.contains(pair.level)) {
                visited.add(pair.level);
                results.add(cur.val);
            };

            if (cur.right != null) 
                deck.offerLast(new Pair(cur.right,pair.level + 1));
            if (cur.left != null) 
                deck.offerLast(new Pair(cur.left, pair.level + 1));
        }

        return results;
    }
}
