class MyStack {

    /**
     * Initialize your data structure here.
     */
    private Queue<Integer> q1 = new LinkedList<Integer>(), q2 = new LinkedList<Integer>();
    private int stackTop;

    public MyStack() {
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q1.add(x);
        stackTop = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int s = q1.size() - 1;
        while (s-- > 0) {
            if (s == 0)
                stackTop = q1.element();
            q2.add(q1.remove());
        }
        int t = q1.remove();
        while (!q2.isEmpty())
            q1.add(q2.remove());
        return t;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return stackTop;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty();
    }
}