package sumu.learning.stack;

public class Stack<T> {
	
	T[] stack;
	int top = -1;
	
	Stack(int size) {
		stack = (T[]) new Object[size];
	}
	
	public void push(T element) {
		if(top == stack.length - 1) {
			System.out.println("Stack Overflow");
			return;
		}
		stack[++top] = element;
		System.out.println("Inserted element " + element);
	}
	
	public T pop() {
		if(top == -1) {
			System.out.println("Stack Underflow");
			return null;
		}
		return stack[top--];
	}
	
	public T peek() {
		if(top == -1) {
			System.out.println("Stack is Empty");
		}
		return stack[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == stack.length - 1;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>(5);
		stack.pop();
		System.out.println(stack.isEmpty());
		stack.push(1);
		stack.push(2);
		System.out.println(stack.isEmpty());
		stack.push(3);
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.push(4);
		stack.push(5);
		System.out.println(stack.isFull());
		stack.push(6);
		System.out.println(stack.isFull());
	}

}
