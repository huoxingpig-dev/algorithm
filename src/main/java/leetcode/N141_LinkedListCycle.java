package leetcode;

import leetcode.helper.ListNode;

/**
 * Created by langji on 06/01/2020.
 */
public class N141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head, quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) return true;
        }

        return false;
    }
}
