/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    class Pair{
        ListNode node;
        int dis;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return remove(head,n).node;
    }
    private Pair remove(ListNode head,int n)
    {
        if(head==null) 
        {
            Pair p=new Pair();
            p.node=null;
            p.dis=1;
            return p;
        }
        Pair smallAns=remove(head.next,n);
        Pair ans=new Pair();
        head.next=smallAns.node;
        if(smallAns.dis==n)
            head=head.next;
        ans.node=head;
        ans.dis=smallAns.dis+1;
        
        return ans;
    }
}
// @lc code=end

