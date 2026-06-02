/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Integer> nodeIndexMap = new HashMap<>(); // original
        HashMap<Integer, Node> indexNodeMap = new HashMap<>(); // copy

        Node result = new Node(0);
        Node cur = head; // Main iterator
        Node itr = result; //Copy iterator

        // Create deep copy
        int idx = 0;
        while (cur != null) {
            itr.next = new Node(cur.val);
            nodeIndexMap.put(cur, idx);
            indexNodeMap.put(idx, itr.next);
            cur = cur.next;
            itr = itr.next;

            idx++;
        }

        // System.out.println("--");
        // for (Node key : nodeIndexMap.keySet()) {
        //     System.out.println("node val = "+key.val);
        //     System.out.println("index = "+nodeIndexMap.get(key));
        // }
        // System.out.println("--");

        // System.out.println("--");
        // for (Integer key : indexNodeMap.keySet()) {
        //     System.out.println("index = "+key);
        //     System.out.println("node ="+indexNodeMap.get(key).val);
        // }
        // System.out.println("--");

        cur = head;
        itr = result.next;
        while (cur != null && itr != null) {
            if (nodeIndexMap.containsKey(cur.random)) {
                int index = nodeIndexMap.get(cur.random);
                // System.out.println("Old Node = "+cur.val);
                // System.out.println("Old Index = "+index);
                Node tmp = indexNodeMap.get(index);
                // System.out.println("New Node = "+tmp.val);
                itr.random = tmp;
            } else {
                itr.random = null;
            }

            cur = cur.next;
            itr = itr.next;
        }


        return result.next;
    }
}
