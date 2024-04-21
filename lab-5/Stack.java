public class Stack {
    private int[] data;
    private int top;
    private int maxSize;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.data = new int[maxSize];
        this.top = -1;
    }

    public void push(int value) throws StackOverflowException {
        if (top == maxSize - 1) {
            throw new StackOverflowException("Stack is full");
        }
        data[++top] = value;
    }

    public int pop() throws StackUnderflowException {
        if (top == -1) {
            throw new StackUnderflowException("Stack is empty");
        }
        return data[top--];
    }

    public int peek() throws StackUnderflowException {
        if (top == -1) {
            throw new StackUnderflowException("Stack is empty");
        }
        return data[top];
    }
}

