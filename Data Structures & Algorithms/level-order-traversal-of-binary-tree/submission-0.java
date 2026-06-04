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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Pair> deck = new ArrayDeque<>();

        if (root == null) return result;
        
        deck.offerLast(new Pair(root,1));

        while(!deck.isEmpty()) {
            Pair pair = deck.pollFirst();
            TreeNode cur = pair.node;
            Integer level = pair.level;

            if (level > result.size()) {
                result.add(new ArrayList<>(List.of(cur.val)));
            } else {
                result.get(result.size() -1).add(cur.val);
            }

            if (cur.left != null) {
                deck.offerLast(new Pair(cur.left, level + 1));
            }
            if (cur.right != null) {
                deck.offerLast(new Pair(cur.right, level + 1));
            }
        }

        return result;
    }
}
