package graph;

import common.ListNode;

public class LinkedListCycleFaster {

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

