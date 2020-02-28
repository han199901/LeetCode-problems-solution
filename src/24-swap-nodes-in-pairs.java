/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        else {
            ListNode pre, cur, next;
            pre = new ListNode(0);
            pre.next = head;
            cur = head;
            next = cur.next;
            while (next != null) {

                cur.next = next.next;
                next.next = cur;
                pre.next = next;
                if (head == cur)
                    head = next;
                ListNode t;
                t = cur;
                cur = next;
                next = t;
                int n = 2;
                while (n-- != 0 && next != null) {
                    next = next.next;
                    pre = pre.next;
                    cur = cur.next;
                }
            }
        }
        return head;
    }
}