/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> deck = new ArrayDeque<>();

        while (head != null) {
            deck.offerLast(head);
            head = head.next;
        }

        head = deck.pollFirst();

        while (!deck.isEmpty()) {
            if (!deck.isEmpty() && deck.peekLast() != null) {
                if (head != null) {
                    head.next = deck.pollLast();
                    head = head.next;
                }
            }
            if (!deck.isEmpty() && deck.peekFirst() != null) {
                if (head != null) {
                    head.next = deck.pollFirst();
                    head = head.next;
                }
            }
        }
        head.next = null;
    }
}
