package linkedList;

import common.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(9);


        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(9);
        ListNode listNode44 = new ListNode(9);
        ListNode listNode45 = new ListNode(9);
        ListNode listNode46 = new ListNode(9);
        ListNode listNode47 = new ListNode(9);
        ListNode listNode48 = new ListNode(9);
        ListNode listNode49 = new ListNode(9);
        ListNode listNode50 = new ListNode(9);
        ListNode listNode51 = new ListNode(9);
        listNode5.next = listNode6;
        listNode6.next = listNode44;
        listNode44.next = listNode45;
        listNode45.next = listNode46;
        listNode46.next = listNode47;
        listNode47.next = listNode48;
        listNode48.next = listNode49;
        listNode49.next = listNode50;
        listNode50.next = listNode51;
        ListNode listNode = addTwoNumbers(listNode2, listNode5);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode first = l1, second = l2, curr = dummyHead;

        int carry = 0;
        while (first != null || second != null) {
            int x = (first != null) ? first.val : 0;
            int y = (second != null) ? second.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (first != null) first = first.next;
            if (second != null) second = second.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
