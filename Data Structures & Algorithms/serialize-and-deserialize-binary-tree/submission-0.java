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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) {
                sb.append("N,");
                continue;
            }

            sb.append(cur.val+",");

            stack.push(cur.right);
            stack.push(cur.left);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",\\s*")));

        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        String token = queue.poll();

        if (token.equals("N")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(token));

        root.left = helper(queue);
        root.right = helper(queue);

        return root;
    }
}
