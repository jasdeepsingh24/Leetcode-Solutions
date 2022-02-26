/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    class Pair {
        ListNode root;
        ListNode last;

        Pair(ListNode root, ListNode last) {
            this.root = root;
            this.last = last;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int i = 0;
        while (temp != null && i < k) {
            i++;
            temp = temp.next;
        }
        if (i < k)
            return head;
        ListNode sublist = reverseKGroup(temp, k);
        Pair p = reverseKNodes(head, k);
        p.last.next = sublist;
        return p.root;

    }

    public Pair reverseKNodes(ListNode head, int k) {
        int i = 0;
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null && i < k) {
            ListNode x = temp.next;
            temp.next = prev;
            prev = temp;
            temp = x;
            i++;
        }
        return new Pair(prev, head);
    }
}
// @lc code=end
