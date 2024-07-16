import java.util.*;

class Stack<T> {
    class StackUsingList<T> {
        ArrayList<T> arrayList = new ArrayList<>();

        Boolean isEmpty() {
            return arrayList.size() == 0;
        }

        void push(T data) {
            arrayList.add(data);
        }

        T pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return null;
            }
            T num = arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            return num;
        }

        T peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return null;
            }
            return arrayList.get(arrayList.size() - 1);
        }
    }

    void printStack(StackUsingList<T> obj) {
        while (!obj.isEmpty()) {
            System.out.println(obj.pop());
        }
    }

    void pushAtBottom(StackUsingList<T> obj, T data) {
        if (obj.isEmpty()) {
            obj.push(data);
            return;
        }

        T remove = obj.pop();
        pushAtBottom(obj, data);
        obj.push(remove);
    }

    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        Stack<Character>.StackUsingList<Character> stack = s.new StackUsingList<>();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.push('D');

        s.printStack(stack);
    }
}
