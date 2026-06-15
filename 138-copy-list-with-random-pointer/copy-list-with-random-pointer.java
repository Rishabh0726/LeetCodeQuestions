/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp=head;
        HashMap<Node, Node> map=new HashMap<>();
        while(temp!=null){
            Node nextNode=new Node(temp.val);
            map.put(temp, nextNode);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            Node copiedNode=map.get(temp);
            copiedNode.next=map.get(temp.next);
            copiedNode.random=map.get(temp.random);
            temp=temp.next;
        }
        return map.get(head);
    }
}