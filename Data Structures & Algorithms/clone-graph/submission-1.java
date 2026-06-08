/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Map<Integer, Node> newNodes = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(node);
        Node masterClone = new Node(node.val);
        newNodes.put(node.val, masterClone);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            Node clone = new Node(cur.val);
            if (newNodes.containsKey(cur.val)) {
                clone = newNodes.get(cur.val);
            }

            for (Node n : cur.neighbors) {
                if (!newNodes.containsKey(n.val)) {
                    newNodes.put(n.val, new Node(n.val));
                    q.add(n);
                }

                clone.neighbors.add(newNodes.get(n.val));
            }
        }

        return masterClone;
    }
}