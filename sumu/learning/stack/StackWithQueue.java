package sumu.learning.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackWithQueue<T> {
	
	Queue<T> q1;
	Queue<T> q2;
	
	StackWithQueue(int size) {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}
	
	public void push(T element) {
		q1.add(element);
		while(!q2.isEmpty()) {
			q1.add(q2.remove());
		}
		Queue<T> temp = q1;
		q1 = q2;
		q2 = temp;
		System.out.println("Element added successfully!");
	}
	
	public T pop() {
		return q2.remove();
	}
	
	public static void main(String[] args) {
		StackWithQueue<Integer> stk = new StackWithQueue<>(5);
		stk.push(1);
		stk.push(2);
		System.out.println(stk.q2);
		stk.pop();
		System.out.println(stk.q2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
	}
	
	

}
