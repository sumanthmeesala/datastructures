package sumu.learning.LinkedList;

class Node {
	int data;
	Node next;
	
	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class SingleLinkedList {
	
	public static Node insertAtBegining(Node head, int value) {
		return new Node(value, head);
	}
	
	public static void insertAtIndex(Node head, int value, int k ) {
		Node newNode = new Node(value);
		int val = 0;
		while(val++ < k) {
			head = head.next;
		}
		newNode.next = head.next;
		head.next = newNode;
	}
	
	public static void insertAtEnd(Node head, int value) {
		Node node = new Node(value);
		while(head.next != null) {
			head = head.next;
		}
		head.next = node;
	}
	
	public static Node deleteAtBegining(Node head) {
		return head.next;
	}
	
	public static void deleteAtEnd(Node head) {
		while(head.next.next != null) {
			head = head.next;
		}
		head.next = null;
	}
	
	public static void deleteAtIndex(Node head, int index) {
		int val = 1;
		while(val++ < index) {
			head = head.next;
		}
		head.next = head.next.next;
	}
	
	public static void deleteElement(Node head, int value) {
		while(head.next.data != value) {
			head = head.next;
		}
		head.next = head.next.next;
	}
	
	public static void printAllElementsInLinkedList(Node head) {
		while(head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("NULL");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node node = new Node(1);
		insertAtEnd(node, 2);
		insertAtEnd(node, 3);
		insertAtEnd(node, 4);
		node = insertAtBegining(node, 5);
		printAllElementsInLinkedList(node);
		insertAtIndex(node, 6, 2);
		printAllElementsInLinkedList(node);
		node = deleteAtBegining(node);
		printAllElementsInLinkedList(node);
		deleteAtEnd(node);
		printAllElementsInLinkedList(node);
		deleteAtIndex(node, 2);
		printAllElementsInLinkedList(node);
		deleteElement(node, 2);
		printAllElementsInLinkedList(node);
	}
}
