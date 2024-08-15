package sumu.learning.queue;

public class QueueFixedSize<T> {
	
	T[] queue;
	int front;
	int rear;
	
	QueueFixedSize(int size) {
		queue = (T[])new Object[size];
		front = -1;
		rear = -1;
	}
	
	public void enQueue(T element) {
		if(front == -1 && rear == -1) {
			front = rear = 0;
			queue[front] = element;
			System.out.println("Element Inserted!");
			return;
		}
		rear++;
		if(rear >= queue.length) {
			System.out.println("Queue is full! Can not add element into the queue");
			return;
		}
		queue[rear] = element;
		System.out.println("Element Inserted!");
	}
	
	public T deQueue() {
		if(front == -1) {
			System.out.println("Queue is Empty! Can not remove element from the queue");
			return null;
		}
		if(front > rear) {
			System.out.println("There are no elements to remove");
			return null;
		}
		T element = queue[front];
		front++;
		return element;
	}
	
	public boolean isEmpty() {
		return front == -1 || front > rear;
	}
	
	public boolean isFull() {
		return rear >= queue.length;
	}
	
	public T peek() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
			return null;
		}
		return queue[rear];
	}
	
	public static void main(String[] args) {
		QueueFixedSize<Integer> q = new QueueFixedSize<>(5);
		System.out.println(q.isEmpty());
		q.enQueue(1);
		System.out.println(q.isEmpty());
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.isEmpty());
		q.enQueue(1);
		q.enQueue(1);
		q.enQueue(1);
		q.enQueue(1);
	}
	
}
