package sumu.learning.queue;

import java.util.Arrays;

public class DeQueue<T> {
	
	T[] queue;
	int front;
	int rear;
	
	DeQueue(int size) {
		queue = (T[])new Object[size];
		front = rear = -1;
	}
	
	public void insertAtFront(T element) {
		if((front == 0 && rear == queue.length - 1) || (front + 1 == rear)) {
			System.out.println("Queue is Full!");
			return;
		}
		if(front == -1) {
			front = rear = 0;
			queue[front] = element;
			System.out.println(element + " added successfully!");
			return;
		}
		if(front < 1) {
			front = queue.length - 1;
			queue[front] = element;
			System.out.println(element + " added successfully!");
			return;
		}
		front = front - 1;
		queue[front] = element;
		System.out.println(element + " added successfully!");
	}
	
	public void insertAtRear(T element) {
		if((front == 0 && rear == queue.length - 1) || (rear == front + 1)) {
			System.out.println("Queue is Full!");
			return;
		}
		if(front == -1) {
			front = rear = 0;
			queue[front] = element;
			System.out.println(element + " added successfully!");
			return;
		}
		if(rear == queue.length - 1) {
			rear = 0;
			queue[rear] = element;
			System.out.println(element + " added successfully!");
		}
		rear++;
		queue[rear] = element;
		System.out.println(element + " added successfully!");
	}
	
	public T deleteAtFront() {
		if(front == -1) {
			System.out.println("Queue is Empty!");
			return null;
		}
		if(front == rear) {
			T element = queue[front];
			front = rear = -1;
			System.out.println(element + " deleted successfully!");
			return element;
		}
		if(front == queue.length - 1) {
			T element = queue[front];
			front = 0;
			System.out.println(element + " deleted successfully!");
			return element;
		}
		T element = queue[front];
		front++;
		System.out.println(element + " deleted successfully!");
		return element;
	}
	
	public T deleteAtRear() {
		if(front == -1) {
			System.out.println("Queue is Empty!");
			return null;
		}
		if(front == rear) {
			T element = queue[rear];
			front = rear = -1;
			System.out.println(element + " deleted Successfully!");
			return element;
		}
		if(rear == 0) {
			T element = queue[rear];
			rear = queue.length - 1;
			System.out.println(element + " deleted successfully!");
			return element;
		}
		T element = queue[rear];
		rear--;
		System.out.println(element + " deleted successfully!");
		return element;
	}
	
	public static void main(String[] args) {
		DeQueue<Integer> dequeue = new DeQueue<>(5);
		dequeue.insertAtFront(1);
		dequeue.insertAtFront(2);
		dequeue.insertAtRear(3);
		dequeue.insertAtRear(4);
		dequeue.insertAtRear(5);
		dequeue.deleteAtFront();
		dequeue.deleteAtFront();
		dequeue.deleteAtRear();
		System.out.println(Arrays.toString(dequeue.queue));
	}
	
}
