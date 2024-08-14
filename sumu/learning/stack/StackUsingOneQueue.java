package sumu.learning.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueue<T> {
	
	Queue<T> stack;
	StackUsingOneQueue() {
		stack = new LinkedList<>();
	}
	
	public void push(T element) {
		stack.add(element);
		int size = stack.size();
		while(size-- > 1) {
			stack.add(stack.remove());
		}
		System.out.println("Element inserted successfully!");
	}
	
	public T pop() {
		return stack.remove();
	}
	
	public static void main(String[] args) {
		StackUsingOneQueue<Integer> stk = new StackUsingOneQueue<>();
		stk.push(1);
		System.out.println(stk.stack);
		stk.push(2);
		System.out.println(stk.stack);
		System.out.println(stk.pop());
		System.out.println(stk.stack);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.stack);
	}
	
	
}

