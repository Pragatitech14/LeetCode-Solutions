import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
     StringBuilder sb1 = new StringBuilder();
     StringBuilder sb2 = new StringBuilder();

     while(l1!=null)
     {
        sb1.append(l1.val);
        l1=l1.next;
     }
     while(l2!=null)
     {
        sb2.append(l2.val);
        l2=l2.next;
     }
     sb1.reverse();
     sb2.reverse();

     BigInteger b1 = new BigInteger(sb1.toString());
     BigInteger b2 = new BigInteger(sb2.toString());

     BigInteger sum = b1.add(b2);
     String result = sum.toString();

    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
     for(int i=result.length()-1;i>=0;i--)
     {
        curr.next = new ListNode(result.charAt(i)-'0');
        curr=curr.next;
     }
     return dummy.next;
    }
}