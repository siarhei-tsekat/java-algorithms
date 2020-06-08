package practice;

import common.ListNode;

public class LinkedListCycleFaster {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode1;
        System.out.println(hasCycle(listNode1));
    }

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {

            if (slow == null || fast == null) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

