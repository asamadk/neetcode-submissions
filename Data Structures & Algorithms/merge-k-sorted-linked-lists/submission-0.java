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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode();
        if (lists.length == 1) {
            return lists[0];
        }

        for (int i=1;i<lists.length;i++) {
            if (i == 1) {
                ListNode tempMerged = mergedList(lists[i], lists[i-1]);
                merged.next = tempMerged;
            } else {
                ListNode tempMerged = mergedList(lists[i], merged.next);
                merged.next = tempMerged;
            }

        }

        return merged.next;
    }

    private ListNode mergedList(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode curr = res;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        } else if (l2 != null) {
            curr.next = l2;
        }

        return res.next;
    }
}
