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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode temp=head;
        ListNode nextNode=null;
        ListNode prevNode=null;
        while(temp!=null){
            ListNode kthNode=findKthNode(temp, k);
            if(kthNode==null){
                if(prevNode!=null)
                prevNode.next=temp;
                break;
            }
            nextNode=kthNode.next;
            kthNode.next=null;
            reverse(temp);
            if(temp==head){
              head=kthNode;
            }else{
                prevNode.next=kthNode;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }

    private ListNode findKthNode(ListNode head, int k){
        ListNode temp=head;
        for(int i=1; i<k; i++){
            if(temp==null)
            return null;
            temp=temp.next;
        }
        return temp;
    }
    
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null)
        return head;
        ListNode back=null;
        ListNode curr=head;
        
        while(curr!=null){
            ListNode front=curr.next;
            curr.next=back;
            back=curr;
            curr=front;
        }
        head=back;
        return head;
    }
}