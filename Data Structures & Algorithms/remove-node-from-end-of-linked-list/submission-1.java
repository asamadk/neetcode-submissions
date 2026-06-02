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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int length = 0;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int target = (length - n);
        if (target == 0) {
            return head.next;
        }

        curr = head;
        for (int i=0;i<length-1;i++) {
            if (target == (i+1)) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }

        return head;
    }
}
