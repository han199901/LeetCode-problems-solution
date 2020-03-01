/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null)
            return false;
        else if (isContain(head, root))
            return true;
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private static boolean isContain(ListNode head, TreeNode root) {
        if(head==null)
            return true;
        else if(root == null)
            return false;
        else if (head.val != root.val)
            return false;
        else
            return isContain(head.next,root.left) || isContain(head.next,root.right);
    }
}