public class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> maxQueue;
    public MaxQueue() {
        queue=new ArrayDeque();
        maxQueue=new ArrayDeque();
    }
    public int max_value() {
        if(maxQueue.isEmpty())
            return -1;
        return maxQueue.peek();
    }
    public void push_back(int value) {
        queue.add(value);
        while(!maxQueue.isEmpty() && value>maxQueue.getLast())
            maxQueue.pollLast();
        maxQueue.add(value);
    }
    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        int ans=queue.poll();
        if(ans==maxQueue.peek())
            maxQueue.poll();
        return ans;
    }
}


/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */