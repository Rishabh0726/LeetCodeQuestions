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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans=new ListNode(-1);
        ListNode dummy= ans;

        ListNode temp1=l1;
        ListNode temp2=l2;
        int carry=0;

        while(temp1!=null || temp2!=null){
            if(temp1!=null && temp2!=null){
                int value=temp1.val+temp2.val+carry;
                temp1.val=value%10;
                carry=value/10;
                dummy.next=temp1;
                dummy=temp1;
                temp1=temp1.next;
                temp2=temp2.next;
            }
            else if(temp2!=null){
            int value=temp2.val+carry;
            temp2.val=value%10;
            carry=value/10;
            dummy.next=temp2;
            dummy=temp2;
            temp2=temp2.next;
            }
            else{
                int value=temp1.val+carry;
                temp1.val=value%10;
                carry=value/10;
                dummy.next=temp1;
                dummy=temp1;
                temp1=temp1.next;
            }
        }
        if(carry!=0)
        dummy.next=new ListNode(carry);

        return ans.next;        
    }
}