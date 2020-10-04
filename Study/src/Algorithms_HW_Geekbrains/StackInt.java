package Algorithms_HW_Geekbrains;


//пример пользовательского класса стека
public class StackInt {
    private int maxSize;
    private int[] stack;
    private int top;

    public StackInt(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
        this.top = -1;
    }

    public void push(int i) {
        this.stack[++this.top] = i;
    }

    public int pop() {
        return this.stack[this.top--];
    }

    public int peek() {
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public int size() {
        return this.top + 1;
    }

    public int maxSize() {
        return this.stack.length;
    }

    public boolean isFull() {
        return this.top + 1 == this.maxSize;
    }

    public int getTop() {
        return this.top;
    }
}
