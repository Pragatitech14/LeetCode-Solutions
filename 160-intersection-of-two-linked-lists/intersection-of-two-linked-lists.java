/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> map = new HashMap<>();

        ListNode temp = headA;
        while(temp!=null)
        {
            map.put(temp,temp.val);
            temp=temp.next;
        }

        ListNode temp2 = headB;
        while(temp2!=null)
        {
            if(map.containsKey(temp2))
            {
                return temp2;
            }
            temp2=temp2.next;
        }
        return null;
    }
}