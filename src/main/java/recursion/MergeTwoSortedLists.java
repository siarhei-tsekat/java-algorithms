package recursion;

import common.ListNode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode4;

        ListNode listNode11 = new ListNode(1);
        ListNode listNode22 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode11.next = listNode22;
        listNode22.next = listNode3;
        ListNode listNode = mergeTwoLists(listNode1, listNode11);
    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val < head2.val) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLists(head1, head2.next);
            return head2;
        }
    }
}
