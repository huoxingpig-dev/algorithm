package leetcode;

import leetcode.helper.ListNode;

/**
 * Created by langji on 06/01/2020.
 */
public class N024_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        return swapTwo(head);
    }

    private ListNode swapTwo(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head.next, pre = head, newHead = head.next.next;
        cur.next = pre;
        pre.next = swapTwo(newHead);

        return cur;
    }
}
