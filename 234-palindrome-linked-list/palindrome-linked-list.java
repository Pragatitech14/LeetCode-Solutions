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
        
        ListNode slow =head;
        ListNode fast =head;
        

        while(fast.next!=null && fast.next.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp =reverse(slow.next);
        ListNode first = head;
        ListNode second = temp;
        while(second!=null)
        {
            if(first.val!=second.val)
            {
               reverse(temp);
                return false;
            }
            first=first.next;
            second =second.next;
        }
        reverse(temp);
       return true;   
    }

    public ListNode reverse(ListNode temp)
    {
        ListNode prev = null;
        ListNode front = null;
        while(temp!=null)
         {
            front = temp.next;
            temp.next = prev;
            prev = temp ;
            temp = front;
         }
       return prev;
    }
}