package leetcode;

import java.util.*;

/**
 * Created by langji on 08/01/2020.
 */
public class N239_SlidingWindowMaximun {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums.length < k) return new int[0];
        int[] results = new int [nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        for (int i = 0; i < nums.length; ++i) {
            // 过了生命周期的
            if (!queue.isEmpty() && queue.peekFirst() <= i-k) {
                queue.pollFirst();
            }
            // 比num[i]小的都应该从队列里清除 -- 此举保证了队列是有序的
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i+1 >= k) results[i+1-k] = nums[queue.peekFirst()];
        }

        return results;
    }

    public static void main(String[] args) {
        N239_SlidingWindowMaximun c = new N239_SlidingWindowMaximun();
        int[] input = new int[]{1,3,1,2,0,5};
        int k = 3;
        int[] results = c.maxSlidingWindow(input, k);

        int[] a = new int[2];
        int[] b = new int[2];
        a[1] = 1;
        b[1] = 1;
        if (a.equals(b)) {  //false
            System.out.print("euqals");
        }
    }
}
