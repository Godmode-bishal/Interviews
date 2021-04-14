package leetcode.linkedlist;

import leetcode.deletellNode.ListNode;

public class AddTwoNum {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        head.val = (l1.val + l2.val)%10;
        ListNode node = head;
        int carry = 0;
        if(l1.val + l2.val >=10)
            carry = 1;
        while(true) {
            if(l1!=null && l1.next != null)
                l1 = l1.next;
            else
                l1 = null;
            if(l2!=null && l2.next!=null)
                l2 = l2.next;
            else
                l2 = null;
            if(l1 !=null || l2!= null) {
                node.next = new ListNode();
                node = node.next;
            }
            else {
                if(carry==1) {
                    node.next = new ListNode(carry);
                }
            }
            if(l1 != null && l2 != null) {
                node.val = (l1.val + l2.val + carry) % 10;
                if (l1.val + l2.val + carry >= 10)
                    carry = 1;
                else
                    carry = 0;
            }
            else if(l1 != null && l2 == null) {
                node.val = (l1.val + carry) % 10;
                if (l1.val + carry >= 10)
                    carry = 1;
                else
                    carry = 0;
            }
            else if(l1 == null && l2 != null){
                node.val = (l2.val + carry) % 10;
                if (l2.val + carry >= 10)
                    carry = 1;
                else
                    carry = 0;
            }
            else
                break;
        }
        return head;
    }

    public static ListNode addTwoNumbersEffcient(ListNode l1, ListNode l2){
        ListNode fake = new ListNode(0);
        ListNode p = fake;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while(p1!=null || p2!=null){
            int sum = carry;
            if(p1!=null){
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2!=null){
                sum += p2.val;
                p2 = p2.next;
            }
            if(sum>9){
                carry=1;
                sum = sum-10;
            }else{
                carry = 0;
            }
            ListNode l = new ListNode(sum);
            p.next = l;
            p = p.next;
        }
        //don't forget check the carry value at the end
        if(carry > 0){
            ListNode l = new ListNode(carry);
            p.next = l;
        }
        return fake.next;
    }
    
    public static void main(String[] args) {
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        l11.next = l12;
        ListNode l13 = new ListNode(9);
        l12.next = l13;
        ListNode l14 = new ListNode(9);
        l13.next = l14;
        ListNode l15 = new ListNode(9);
        l14.next = l15;
        ListNode l16 = new ListNode(9);
        l15.next = l16;
        ListNode l17 = new ListNode(9);
        l16.next = l17;

        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        l21.next = l22;
        ListNode l23 = new ListNode(9);
        l22.next = l23;
        ListNode l24 = new ListNode(9);
        l23.next = l24;
        AddTwoNum.addTwoNumbers(l11,l21);
    }
}
