/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        head.next = l1;
        ListNode t1 = l1, pre = head;
        while (t1 != null && l2 != null) {
            if (t1.val > l2.val) {
                ListNode follow = l2.next;
                l2.next = t1;
                pre.next = l2;

                pre = l2;
                l2 = follow;
            } else {
                t1 = t1.next;
                pre = pre.next;
            }
        }
        if (l2 != null)
            pre.next = l2;
        return head.next;
    }
}