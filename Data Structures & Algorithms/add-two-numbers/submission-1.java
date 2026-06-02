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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curl1 = l1;
        ListNode curl2 = l2;

        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode cur = result;

        while(curl1 != null || curl2 != null) {
            int l1Val = 0;
            int l2Val = 0;
            if (curl1 != null) {
                l1Val = curl1.val;
                curl1 = curl1.next;
            }
            if (curl2 != null) {
                l2Val = curl2.val;
                curl2 = curl2.next;
            }

            int sum = l1Val + l2Val + carry;
            if (sum > 9) {
                carry = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            } else {
                carry = 0;
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return result.next;
    }
}
