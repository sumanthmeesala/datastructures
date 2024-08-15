package sumu.learning.queue;

class Node<T> {
	T value;
	Node<T> next;
	
	Node(T value) {
		this.value = value;
	}
}


public class QueueDynamicSize<T> {
	
	Node<T> front;
	Node<T> rear;
	
	QueueDynamicSize() {
		front = rear = null;
	}
	
	public void enQueue(T value) {
		Node<T> newNode = new Node<>(value);
		if(front == null) {
			front = rear = newNode;
			System.out.println(value +" inserted successfully!");
			return;
		}
		rear.next = newNode;
		rear = newNode;
		System.out.println(value +" inserted successfully!");
	}
	
	public T deQueue() {
		if(front == null) {
			System.out.println("Nothing in the queue");
			return null;
		}
		T element = front.value;
		front = front.next;
		return element;
	}
	
	public T peek() {
		if(front == null) {
			System.out.println("Nothing in the queue");
			return null;
		}
		return front.value;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	public void printElements() {
		Node<T> temp = front;
		while(temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		QueueDynamicSize<String> q = new QueueDynamicSize<>();
		System.out.println(q.peek());
		System.out.println(q.isEmpty());
		q.enQueue("ab");
		q.enQueue("cd");
		System.out.println(q.isEmpty());
		System.out.println(q.deQueue());
		q.printElements();
		q.enQueue("ef");
		q.enQueue("gh");
		q.enQueue("ij");
		q.enQueue("kl");
		q.printElements();
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.isEmpty());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}
	
	
}
