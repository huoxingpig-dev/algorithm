package leetcode;

import java.util.Stack;

/**
 * Created by langji on 07/01/2020.
 */
public class N232_ImplementQueueUsingStacks {
    /** Initialize your data structure here. */
    final Stack<Integer> stack;
    final Stack<Integer> transStack;

    public N232_ImplementQueueUsingStacks() {
        stack = new Stack<Integer>();
        transStack = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (transStack.empty()) {
            while (!stack.empty()) {
                transStack.push(stack.pop());
            }
        }

        return transStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (transStack.empty()) {
            while (!stack.empty()) {
                transStack.push(stack.pop());
            }
        }

        return transStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty() && transStack.empty();
    }
}
