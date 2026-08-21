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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ArrayList<Integer> arr = new ArrayList<>();
        ListNode newlist1 = list1;
        ListNode newlist2 = list2;

        while(newlist1!=null)
        {
            arr.add(newlist1.val);
            newlist1=newlist1.next;
        }
        while(newlist2!=null)
        {
            arr.add(newlist2.val);
            newlist2=newlist2.next;
        }
        Collections.sort(arr);
        if(arr.size() == 0) return null;
        ListNode temp = new ListNode(arr.get(0));
        ListNode head =temp;

        for(int i=1;i<arr.size();i++)
        {
            temp.next =new ListNode(arr.get(i));
            temp=temp.next;
        }

        return head;

    }
}