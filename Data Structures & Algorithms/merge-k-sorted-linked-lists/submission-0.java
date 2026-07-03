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
        if (lists.length == 0) {
            return null;
        }

        for (int i = 1; i < lists.length; i++) {
            var first = lists[i - 1];
            var second = lists[i];

            var intermediateResult = merge(first, second);

            lists[i] = intermediateResult;
        }

        return lists[lists.length - 1];
    }

    public  ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode();

        ListNode tail = result;
        ListNode currentLeft = left;
        ListNode currentRight = right;

        while (currentLeft != null && currentRight != null) {
            if (currentLeft.val <= currentRight.val) {
                tail.next = currentLeft;

                currentLeft = currentLeft.next;
            } else {
                tail.next = currentRight;

                currentRight = currentRight.next;
            }

            tail = tail.next;
        }

        if (currentLeft != null) {
            tail.next = currentLeft;
        } else {
            tail.next = currentRight;
        }

        return result.next;
    }
}
