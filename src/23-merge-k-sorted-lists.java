/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 根据两个链表合并，反复利用就可以实现多链表合并 但效率不高；
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        for (int i = 1; i < lists.length; i++)
            lists[0] = mergeTwoLists(lists[0], lists[i]);
        return lists[0];
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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


