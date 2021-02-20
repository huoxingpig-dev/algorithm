package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by langji on 08/01/2020.
 */
public class N703_KthLargestElementInAStream {
    final smallHeap heap;
    /*final PriorityQueue<Integer> queue;
    final int k;*/
    public N703_KthLargestElementInAStream(int k, int[] nums) {
        heap = new smallHeap(k);
        for (int i = 0; i < nums.length; ++i) {
            heap.addItem(nums[i]);
        }
        /*this.k = k;
        // default small heap
        queue = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            add(num);
        }*/
    }

    public int add(int val) {
        /*if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }

        return queue.peek();*/
        heap.addItem(val);
        return heap.peek();
    }

    private static class smallHeap {
        int capacity;
        final int[] heap;
        public smallHeap(int x) {
            capacity = 0;
            heap = new int[x];
        }

        public void addItem(int x) {
            if (capacity < heap.length) {
                heap[capacity] = x;
                siftUp(capacity);
                capacity++;
            } else {
               if (x > heap[0]) {
                   heap[0] = x;
                   siftDown(capacity);
               }
            }
        }

        private void siftUp(int i) {
            while (i > 0) {
                int parent = (i-1)/2;
                if (heap[i] < heap[parent]) {
                    swapNum(i, parent);
                    i = parent;
                } else {
                    return;
                }
            }
        }

        private void siftDown(int len) {
            int cur = 0;
            while (cur < len/2) {
                int left = cur * 2 + 1;
                int right = cur * 2 +2;
                int swap;
                if (right < len && heap[right] < heap[left])
                    swap = right;
                else
                    swap = left;
                if (heap[cur] > heap[swap]) {
                    swapNum(cur,swap);
                    cur = swap;
                } else {
                    return;
                }
                /*if (left < heap.length && heap[cur] > heap[left]) {
                    swapNum(cur, left);
                    cur = left;
                } else if (right < heap.length && heap[cur] > heap[right]) {
                    swapNum(cur, right);
                    cur =right;
                } else {
                    return;
                }*/
            }
        }

        private void swapNum(int x, int y) {
            int temp = heap[x];
            heap[x] = heap[y];
            heap[y] = temp;
        }

        public int peek() {
            return heap[0];
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{0};
        int k = 2;
        N703_KthLargestElementInAStream c = new N703_KthLargestElementInAStream(k, input);
        int x = c.add(3);
        System.out.print(x);
        x = c.add(5);
        System.out.print(x);
        x = c.add(10);
        System.out.print(x);
        x = c.add(9);
        System.out.print(x);
        x = c.add(5);
        System.out.print(x);

    }
}
