/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = nul l;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       boolean cycle = false;

       while(fast!=null && fast.next!=null) 
       {
        slow = slow.next;
        fast=fast.next.next;
        if(fast==slow)
        {
            cycle =true;
            break;
        }
       } 
        if(!cycle)
        {

            return null;
        }
        slow =head;
        while(fast!=null)
          {
             if(fast==slow)
           {
            return slow;
           }
           fast= fast.next;
           slow =slow.next;
    
          }

      return null;   
    }
}