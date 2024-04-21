public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println("Peek: " + stack.peek());
            System.out.println("Pop: " + stack.pop());
            System.out.println("Peek after pop: " + stack.peek());
            stack.push(4);
            stack.push(5);
            stack.push(6);  // Va arunca o StackOverflowException
        } catch (StackOverflowException | StackUnderflowException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
