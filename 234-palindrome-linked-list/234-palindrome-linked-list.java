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
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head,slow=head, temp=head;
        int length=0;
        
        //find length
        while(temp!=null) {
            length++; temp=temp.next;
        }
        if(length==1) return true;
        
        //find mid
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        
        
        //set cur and prev to mid of ll, to reverse 2nd half
        ListNode prev=head, cur=slow;
        while(prev.next!=cur) {
            prev=prev.next;
        }
        
        
        //reverse
        while(cur!=null) {
            ListNode t=cur.next;
            cur.next=prev;
            prev=cur;
            cur=t;
        }
        
        //1 pointer at the start, other at the end, 
        ListNode end=prev;
        ListNode start=head;
        int count=0,halfLength=length/2;
        
        
        //move both 1 step at a time, compare vals, if not equal false, if all equal return true;
        while(halfLength-->0) {
            if(start.val!=end.val) 
                return false;
            start=start.next;
            end=end.next;
            
        }
        
        return true;

    }
}