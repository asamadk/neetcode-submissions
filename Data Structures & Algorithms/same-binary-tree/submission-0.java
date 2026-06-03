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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<TreeNode> pList = traverse(p);
        List<TreeNode> qList = traverse(q);

        if (pList.size() != qList.size())
            return false;

        for (int i = 0; i < pList.size(); i++) {
            TreeNode pNode = pList.get(i);
            TreeNode qNode = qList.get(i);

            if (pNode.val != qNode.val)
                return false;
        }

        return true;
    }

    private List<TreeNode> traverse(TreeNode node) {
        if (node == null) {
            return new ArrayList<>(List.of(new TreeNode(Integer.MIN_VALUE)));
        }

        List<TreeNode> list = new ArrayList<>();
        list.addAll(traverse(node.left));
        list.addAll(traverse(node.right));

        list.add(node);

        return list;
    }
}
