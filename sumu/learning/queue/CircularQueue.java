package sumu.learning.queue;

public class CircularQueue<T> {
	T[] queue;
	int front;
	int rear;
	
	CircularQueue(int size) {
		queue = (T[])new Object[size];
		front = -1;
		rear = -1;
	}
	
	public boolean isEmpty() {
		return front == -1;
	}
	
	public boolean isFull() {
		if(front == rear + 1) return true;
		if(front == 0 && rear == queue.length - 1) return true;
		return false;
	}
	
	public void enQueue(T element) {
		if(isFull()) {
			System.out.println("Queue is full!");
			return;
		}
		if(front == -1 && rear == -1) {
			front = rear = 0;
			queue[front] = element;
			System.out.println(element + " inserted successfully!");
			return;
		}
		if(rear == queue.length - 1 && front != 0) {
			rear = 0;
			queue[rear] = element;
			System.out.println(element + " inserted successfully!");
			return;
		}
		rear++;
		queue[rear] = element;
		System.out.println(element + " inserted successfully!");
	}
	
	public T deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
			return null;
		}
		if(front == rear) {
			T element = queue[front];
			front = rear = -1;
			System.out.println(element + " Deleted Successfully!");
			return element;
		}
		if(front == queue.length - 1 && rear != queue.length) {
			T element = queue[front];
			front = 0;
			System.out.println(element + " Deleted Successfully!");
			return element;
		}
		T element = queue[front];
		front++;
		System.out.println(element + " Deleted Successfully!");
		return element;
	}
	
	public static void main(String[] args) {
		CircularQueue<Integer> q = new CircularQueue<>(5);
		System.out.println(q.isEmpty());
		System.out.println(q.isFull());
		q.enQueue(1);
		System.out.println(q.isEmpty());
		System.out.println(q.isFull());
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		q.enQueue(6);
		q.deQueue();
		q.enQueue(7);
		q.enQueue(1);
		q.enQueue(1);
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
	}

}
