package stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementingStackUsingQueue {

    /**
     *
     *
     * Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal queue (push, top, pop, and empty).
     *
     * Implement the MyStack class:
     *
     * void push(int x) Pushes element x to the top of the stack.
     * int pop() Removes the element on the top of the stack and returns it.
     * int top() Returns the element on the top of the stack.
     * boolean empty() Returns true if the stack is empty, false otherwise.
     * Notes:
     *
     * You must use only standard operations of a queue, which means only push to back, peek/pop from front, size, and is empty operations are valid.
     * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue), as long as you use only a queue's standard operations.
     *
     *
     * Example 1:
     *
     * Input
     * ["MyStack", "push", "push", "top", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * Output
     * [null, null, null, 2, 2, false]
     *
     * Explanation
     * MyStack myStack = new MyStack();
     * myStack.push(1);
     * myStack.push(2);
     * myStack.top(); // return 2
     * myStack.pop(); // return 2
     * myStack.empty(); // return False
     *
     *
     * Constraints:
     *
     * 1 <= x <= 9
     * At most 100 calls will be made to push, pop, top, and empty.
     * All the calls to pop and top are valid.
     *
     */

    Queue<Integer> q1;
    Queue<Integer> q2;

    private int top;
    public ImplementingStackUsingQueue() {
        q1=new LinkedList();
        q2=new LinkedList();
        top=-1;
    }

    /** Push element x onto stack.
     * Time complexity : O(1)O(1). Queue is implemented as linked list and add operation has O(1)O(1) time complexity.
     *
     * Space complexity : O(1)O(1)
     * */
    public void push(int x) {

        q1.add(x);
        this.top=x;
    }

    /** Removes the element on top of the stack and returns that element.
     *
     * Complexity Analysis
     *
     * Time complexity : O(n)O(n). The algorithm dequeues n elements from q1 and enqueues n - 1 elements to q2, where n is the stack size. This gives 2n - 1 operations.
     * Space complexity : O(1)O(1).
     *
     *
     * */
    public int pop() {

        int DeletedElement=this.top;
        int i=0;
        int n=q1.size();
        while(i<n-1){
            top=q1.remove();
            q2.add(top);
            i++;
        }
        //top will have latest element
        q1.remove();
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return DeletedElement;
    }

    /** Get the top element. */
    public int top() {

        return this.top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return q1.isEmpty();
    }
    public static void main(String[] args) {

        ImplementingStackUsingQueue stack=new ImplementingStackUsingQueue();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.top());
        int pop = stack.pop();
        System.out.println(pop);
        int pop2 = stack.pop();
        int pop3 = stack.pop();
        stack.push(10);
    }
}
