package practice;

/***
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 *
 * FreqStack has two functions:
 *
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 *
 */
public class FreqStack {


    public FreqStack() {

    }

    public void push(int x) {

    }

    public int pop() {
      return 0;
    }
}

class Solution {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println("Expected: 5 => "+freqStack.pop());
        System.out.println("Expected: 7 => "+freqStack.pop());
        System.out.println("Expected: 5 => "+freqStack.pop());
        System.out.println("Expected: 4 => "+freqStack.pop());

    }
}