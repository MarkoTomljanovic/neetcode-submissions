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

        return mergeSort(lists, 0, lists.length - 1);
    }

    public ListNode mergeSort(ListNode[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }

        var mid = l + (r - l) / 2;

        var left = mergeSort(arr, l, mid);
        var right = mergeSort(arr, mid + 1, r);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
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
