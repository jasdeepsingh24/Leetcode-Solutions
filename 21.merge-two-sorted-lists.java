/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        ListNode root=null;
        ListNode head=null;
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                if(root==null){
                    root=new ListNode(l1.val);
                    head=root;
                    
                }
                else
                {
                    root.next=new ListNode(l1.val);
                    root=root.next;
                }
                l1=l1.next;
            }
            else
            {
                if(root==null){
                    root=new ListNode(l2.val);
                    head=root;  
                }
                else
                {
                    root.next=new ListNode(l2.val);
                    root=root.next;
                }
                l2=l2.next;
            }
            
        }
        while(l1!=null)
        {
            if(root==null){
                root=new ListNode(l1.val);
                head=root;
            }
            else{
            root.next=new ListNode(l1.val);
            root=root.next;
            }
            l1=l1.next;
        }
        while(l2!=null)
        {
            if(root==null){
                root=new ListNode(l2.val);
                head=root;
            }
            else{
            root.next=new ListNode(l2.val);
            root=root.next;
            }
            l2=l2.next;
        }
        return head;
    }
}
// @lc code=end

