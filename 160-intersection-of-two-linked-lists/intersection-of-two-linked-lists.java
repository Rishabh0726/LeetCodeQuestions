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
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA.next!=null && tempB.next!=null){
            tempA=tempA.next;
            tempB=tempB.next;
        }
        if(tempA.next==null){
            tempA=headB;
            while(tempB.next!=null){
                tempA=tempA.next;
                tempB=tempB.next;
            }
            tempB=headA;
            while(tempA!=tempB){
                tempA=tempA.next;
                tempB=tempB.next;
            }
        }else{
            tempB=headA;
            while(tempA.next!=null){
                tempA=tempA.next;
                tempB=tempB.next;
            }
            tempA=headB;
            while(tempA!=tempB){
                tempA=tempA.next;
                tempB=tempB.next;
            }
        }
        return tempA;
    }
}