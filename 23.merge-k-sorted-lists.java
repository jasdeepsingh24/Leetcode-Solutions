/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        int flag=1;
        ListNode ans=null;
        ListNode head=null;
        do{
            flag=1;
            Pair min=new Pair();
            min.data=Integer.MAX_VALUE;
            for(int i=0;i<lists.length;i++)
            {
                Pair p=new Pair();
                if(lists[i]!=null)
                {
                    flag=0;
                    p.node=lists[i];
                    p.data=p.node.val;
                    p.pos=i;
                    
                    if(p.data<min.data)
                        min=p;
                }
            }
            if(min.data!=Integer.MAX_VALUE)
            {
                if(ans==null){
                    ans=new ListNode(min.data);
                    head=ans;
                }
                else{
                    ans.next=new ListNode(min.data);
                    ans=ans.next;
                }
                lists[min.pos]=lists[min.pos].next;
            }
            
        }while(flag!=1);
        return head;
        
    }
    class Pair{
        ListNode node;
        int data;
        int pos;
    }
}
// @lc code=end
