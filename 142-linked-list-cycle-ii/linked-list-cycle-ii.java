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

        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode temp = head;
        while(temp!=null)
        {
        if(map.containsKey(temp))
        {
            return temp;
        }
        map.put(temp,1);
        temp=temp.next;
        }


      return null;   
    }
}