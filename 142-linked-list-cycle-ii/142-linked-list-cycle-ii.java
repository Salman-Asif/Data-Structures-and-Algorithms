/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head, slow= head;
        
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)
                break;
        }
        if(fast == null || fast.next == null) return null;
        
        int cycleLength = 0;
        while(slow.next != fast) {
            slow=slow.next;
            cycleLength++;
        }
        cycleLength++;
        
       // System.out.println("cycleLength " + cycleLength);
        fast=head;
        slow=head;
        while(cycleLength-- > 0) {
            slow=slow.next;
        }
        
        while(fast!=slow) {
            fast=fast.next;
            slow=slow.next;
            if(slow==fast)
                break;
        }
        
       return slow;
    }
}



