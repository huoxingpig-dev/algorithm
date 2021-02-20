package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by langji on 07/01/2020.
 */
public class N225_ImplementStackUsingQueues {
    /** Initialize your data structure here. */
    Queue<Integer> queue;
    Queue<Integer> transQueue;
    int topValue;
    public N225_ImplementStackUsingQueues() {
        queue = new LinkedList<Integer>();
        transQueue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        topValue = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue.size() > 1) {
            topValue = queue.poll();
            transQueue.add(topValue);
        }

        int popValue = queue.poll();
        Queue<Integer> temp = queue;
        queue = transQueue;
        transQueue = temp;

        return popValue;
    }

    /** Get the top element. */
    public int top() {
        return topValue;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
