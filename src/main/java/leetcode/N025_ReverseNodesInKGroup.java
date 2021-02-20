package leetcode;

import leetcode.helper.ListNode;

/**
 * Created by langji on 06/01/2020.
 */
public class N025_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;

        ListNode walk = head;
        int count = k - 1;
        while (walk.next != null && count > 0) {
            walk = walk.next;
            count--;
        }
        if (count > 0) return head;

        ListNode cur = head, pre = null, post = null;
        for (int i = 0; i < k; ++i) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        head.next = reverseKGroup(post,k);

        return pre;
    }
}
