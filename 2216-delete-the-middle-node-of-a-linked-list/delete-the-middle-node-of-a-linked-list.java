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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        if(head==null || head.next==null)
        {return null;}
        ListNode prev = null;
        int count =0;
        while(temp!=null)
        {
            count++;
            temp =temp.next;
        }
        temp=head;
        int mid = count/2;
        while(mid>0)
        {
            prev=temp;
          temp = temp.next;
          mid--;
        }
         prev.next =temp.next;
        return head;
    }
}