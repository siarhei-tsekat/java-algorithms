package linkedList;

import common.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode next = new ListNode(4);
        ListNode next2 = new ListNode(5);
        first.next = next;
        next.next = next2;

        ListNode second = new ListNode(1);
        ListNode secondNext = new ListNode(3);
        ListNode secondThird = new ListNode(4);
        second.next = secondNext;
        secondNext.next = secondThird;

        ListNode third = new ListNode(2);
        ListNode thirdNext = new ListNode(6);
        third.next = thirdNext;

        ListNode[] lists = new ListNode[3];
        lists[0] = first;
        lists[1] = second;
        lists[2] = third;
        ListNode listNode = new __Solution().mergeKLists(lists);
        System.out.println(listNode);
    }
}

class __Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        W w = new W(lists);

        ListNode head = new ListNode();

        head = f(head, w);

        return head;
    }

    public ListNode f(ListNode l, W w) {
        if (w.isEmpty()) return l;

        l = new ListNode(w.next().val);

        l.next = f(l.next, w);
        return l;
    }
}

class W {
    private PriorityQueue<ListNode> q = new PriorityQueue<>((f, s) -> f.val - s.val);

    public W(ListNode[] lists) {
        for (ListNode l : lists) q.add(l);
    }

    public ListNode next() {
        ListNode l = q.poll();
        if (l.next != null) q.add(l.next);
        return l;
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
}
