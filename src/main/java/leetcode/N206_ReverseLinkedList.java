package leetcode;

import leetcode.helper.ListNode;

/**
 * Created by langji on 06/01/2020.
 */
public class N206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        /*if (head.next == null) return head;

        ListNode slow = head, middle = head.next, quick = head;
        slow.next = null;
        while (middle.next != null) {
            quick = middle.next;
            middle.next = head;
            head = middle;
            middle = quick;
        }

        middle.next=head;
        return middle;*/

        ListNode cur = head, pre = null;
        while (cur != null) {
            cur = cur.next;
            pre = cur;
            cur.next = pre;
        }

        return pre;

    }

}
