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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode=null, rightNode=null, leftPrev=null, rightNext=null;
        ListNode prev=null, cur;
        
        cur = head;
        int count = 1;
        
        while(count != left) {
            prev = cur;
            cur = cur.next;
            count++;
        }
        
        //node for leftPrev and leftNode
        leftPrev = prev;
        leftNode = cur;
        
        //reverse
        while(count <= right) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev=cur;
            cur = temp;
          
            count++;
        }
        
        //node for rightNode and rightNext
        rightNode = prev;
        rightNext = cur;
        
              
        if(leftPrev != null) 
            leftPrev.next = rightNode;
    
        
        leftNode.next = rightNext;
        
        return left==1 ? rightNode : head;
    }
}