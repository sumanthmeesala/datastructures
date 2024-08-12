package sumu.learning.stack;

class Node<T> {
	T element;
	Node next;
	Node(T element) {
		this.element = element;
	}
}

public class StackUsingLinkedList<T> {
	Node<T> top;
	StackUsingLinkedList() {
		top = null;
	}
	
	public void push(T element) {
		Node<T> newNode = new Node<>(element);
		if(top == null) {
			top = newNode;
			System.out.println("Pushed element " + element);
			return;
		}
		newNode.next = top;
		top = newNode;
		System.out.println("Pushed element " + element);
	}
	
	public T pop() {
		if(top == null) {
			System.out.println("stack Underflow");
			return null;
		}
		T ele = top.element;
		top = top.next;
		return ele;
	}
	
	public T peek() {
		if(top == null) {
			System.out.println("Stack Underflow");
			return null;
		}
		T element = top.element;
		return element;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public static void main(String[] args) {
		StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
		stack.pop();
		System.out.println(stack.isEmpty());
		stack.push(1);
		System.out.println(stack.isEmpty());
		stack.push(2);
		System.out.println(stack.peek());
		stack.push(3);
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
	}
	
}
