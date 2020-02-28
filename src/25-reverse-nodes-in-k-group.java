/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        else {
            ListNode[] ns = new ListNode[k];
            ListNode p = head;
            ListNode pre = new ListNode(0);
            pre.next = head;
            while (p != null) {
                boolean flag = false;
                if (p == head)
                    flag = true;
                for (int i = 0; i < ns.length; i++) {
                    ns[i] = p;
                    if (p == null)
                        return head;
                    p = p.next;
                }

                for (int i = ns.length - 1; i > 0; i--)
                    ns[i].next = ns[i - 1];
                pre.next = ns[ns.length - 1];
                ns[0].next = p;
                if (flag == true)
                    head = ns[ns.length - 1];

                pre = ns[0];
            }
        }
        return head;
    }
}