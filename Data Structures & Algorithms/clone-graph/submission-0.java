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
    Map<Integer, Node> newNodes = new HashMap<>();
    

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (node == null) return null;

        if (newNodes.containsKey(node.val)) {
            return newNodes.get(node.val);
        }
        
        Node clone = new Node(node.val);
        newNodes.put(node.val, clone);

        for (Node n: node.neighbors) {
            Node cloneNeighbour = dfs(n);
            clone.neighbors.add(cloneNeighbour);
        }

        return clone;
    }
}