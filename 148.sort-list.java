/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode m = findCount(head);
        ListNode h2 = m.next;
        m.next = null;

        ListNode head1 = sortList(head);
        ListNode head2 = sortList(h2);
        return sort(head1, head2);

    }

    private ListNode sort(ListNode h1, ListNode h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
        ListNode head = null;
        ListNode HEAD = null;
        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                if (head == null) {
                    head = new ListNode(h1.val);
                    HEAD = head;
                    h1 = h1.next;
                    continue;
                }
                head.next = new ListNode(h1.val);
                head = head.next;
                h1 = h1.next;
            } else {
                if (head == null) {
                    head = new ListNode(h2.val);
                    HEAD = head;
                    h2 = h2.next;
                    continue;
                }
                head.next = new ListNode(h2.val);
                head = head.next;
                h2 = h2.next;
            }
        }
        while (h1 != null) {
            head.next = new ListNode(h1.val);
            h1 = h1.next;
            head = head.next;
        }
        while (h2 != null) {
            head.next = new ListNode(h2.val);
            h2 = h2.next;
            head = head.next;
        }
        return HEAD;
    }

    private ListNode findCount(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
// @lc code=end
