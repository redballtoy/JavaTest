package Algorithms.graph_01;

class Stack {
    private int maxSize;
    private int[] stackAttr;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackAttr = new int[size];
        this.top = -1;
    }

    public void push(int i) {
        stackAttr[++top] = i;
    }

    public int pop() {
        return stackAttr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int peek() {
        return stackAttr[top];
    }
}