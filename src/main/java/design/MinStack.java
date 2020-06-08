package design;

class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        minStack.getMin();
        minStack.top();
        minStack.pop();
        minStack.getMin();
        System.out.println(minStack);
    }
}

public class MinStack {
    Node first;

    public MinStack() {

    }

    public void push(int x) {
        if (first == null) {
            first = new Node(x, x, null);
        } else {
            first = new Node(x, Math.min(x, first.min), first);
        }
    }

    public void pop() {
        first = this.first.next;
    }

    public int top() {
        return first.val;
    }

    public int getMin() {
        return first.min;
    }
}
class Node {
    int val;
    int min;
    Node next;

    Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
