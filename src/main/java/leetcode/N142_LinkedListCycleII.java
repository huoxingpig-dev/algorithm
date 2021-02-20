package leetcode;

import leetcode.helper.ListNode;

/**
 * Created by langji on 06/01/2020.
 */
public class N142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, quick = head;
        boolean detect = false;

        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                detect = true;
                break;
            }
        }

        if (!detect) return null;

        // notice the distance each pointer had already walked
        // (m + l) * 2 = m + l + n*r -> m + l = nr
        // m = nr -l , meet at the start of circle
        slow = head;
        while (slow != quick) {
            slow = slow.next;
            quick = quick.next;
        }

        return slow;
    }
}
