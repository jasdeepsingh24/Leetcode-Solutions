/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        
        ListNode head=null;
        ListNode tail=null;
        int carry=0;
        while(temp1!=null && temp2!=null)
        {
            int x=temp1.val+temp2.val+carry;
            carry=0;
            int number=x;
            if(x>=10)
            {
                carry=x/10;
                number=x%10;
            }
                
            ListNode toAdd=new ListNode(number);
            if(head==null)
            {
                head=toAdd;
                tail=toAdd;
            }
            else
            {
                tail.next=toAdd;
                tail=tail.next;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        while(temp1!=null)
        {
            int x=temp1.val+carry;
            carry=0;
            int number=x;
            if(x>=10)
            {
                carry=x/10;
                number=x%10;
            }
            ListNode toAdd=new ListNode(number);
            if(head==null)
            {
                head=toAdd;
                tail=toAdd;
            }
            else
            {
                tail.next=toAdd;
                tail=tail.next;
            }
            temp1=temp1.next;
        }
        while(temp2!=null)
        {
            int x=temp2.val+carry;
            carry=0;
            int number=x;
            if(x>=10)
            {
                carry=x/10;
                number=x%10;
            }
            ListNode toAdd=new ListNode(number);
            if(head==null)
            {
                head=toAdd;
                tail=toAdd;
            }
            else
            {
                tail.next=toAdd;
                tail=tail.next;
            }
            temp2=temp2.next;
        }
        if(carry!=0)
        {
            ListNode toAdd=new ListNode(carry);
            if(head==null)
            {
                head=toAdd;
                tail=toAdd;
            }
            else
            {
                tail.next=toAdd;
                tail=tail.next;
            }
        }
        
        return head;
    }
}
// @lc code=end

