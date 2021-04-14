package leetcode.linkedlist;

import leetcode.deletellNode.ListNode;

public class OddEvenLL {
    public ListNode oddEvenList(ListNode head) {
        /*if(head==null || head.next==null || head.next.next==null )
            return head;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenNodeStart = evenNode;
        while(oddNode.next.next != null && evenNode.next.next != null) {
            oddNode.next = oddNode.next.next;
            oddNode = oddNode.next;
            evenNode.next = evenNode.next.next;
            evenNode = evenNode.next;
        }
        if(oddNode.next.next !=null) {
            oddNode.next = oddNode.next.next;
            oddNode = oddNode.next;
            evenNode.next = null;
        }
        oddNode.next = evenNodeStart;
        return head;*/
        if(head==null)
            return head;
        ListNode odd = head, even=head.next, evenH = head.next;
        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        odd.next = evenH;
        return head;
    }
    public static void main(String[] args) {
        OddEvenLL obj = new OddEvenLL();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        /*
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
*/
        node1.next = node2;
        node2.next = node3;
        /*
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
*/
        obj.oddEvenList(node1);
    }
}
