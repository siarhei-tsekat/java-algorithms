package linkedList;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergekList {


    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<ListNode>(Comparator.comparing((l) -> l.val));
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            while (list != null) {
                queue.add(list);
                list = list.next;
            }
        }
        return create(queue);
    }

    private static ListNode create(Queue<ListNode> queue) {
        if (queue.peek() == null) {
            return null;
        }
        ListNode first = queue.poll();
        first.next = create(queue);
        return first;
    }
}
