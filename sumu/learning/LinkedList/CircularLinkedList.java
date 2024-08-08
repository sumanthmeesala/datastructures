package sumu.learning.LinkedList;

public class CircularLinkedList {
	
	public static Node insertAtBegining(Node head, int value) {
		Node newNode = new Node(value);
		if(head == null) {
			head = newNode;
			head.next = head;
			return head;
		}
		newNode.next = head.next;
		head.next = newNode;
		return head;
	}
	
	public static Node insertAtEnd(Node head, int value) {
		Node newNode = new Node(value);
		if(head == null) {
			head = newNode;
			head.next = head;
			return head;
		}
		newNode.next = head.next;
		head.next = newNode;
		head = head.next;
		return head;
	}
	
	public static Node insertAtIndex(Node head, int value, int index) {
		Node newNode = new Node(value);
		if(head == null && index == 0) {
			head = newNode;
			head.next = head;
			return head;
		}
		Node currNode = head.next;
		while(index-- > 1) {
			currNode = currNode.next;
		}
		newNode.next = currNode.next;
		currNode.next = newNode;
		return head;
	}
	
	public static Node deleteAtBegining(Node head){
		if(head == null) {
			System.out.println("Nothing to delete");
			return null;
		}
		if(head.next == head) {
			head = null;
			return null;
		}
		head.next = head.next.next;
		return head;
	}
	
	public static Node deleteAtEnd(Node head) {
		if(head == null) {
			System.out.println("Nothing to delete");
			return null;
		}
		if(head.next == head) {
			return null;
		}
		Node node = head.next;
		while(node.next != head) {
			node = node.next;
		}
		node.next = node.next.next;
		return node;
	}
	
	public static Node deleteAtIndex(Node head, int index) {
		if(head == null) {
			System.out.println("Nothing to delete");
			return null;
		}
		Node node = head.next;
		while(index-- > 1) {
			node = node.next;
		}
		node.next = node.next.next;
		return head;
	}
	
	public static void print(Node node) {
		Node head = node.next;
		do {
			System.out.print(head.data + " -> ");
			head = head.next;
		}while(head != node.next);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node node = null;
		node = deleteAtBegining(node);
		node = insertAtBegining(node, 1);
		print(node);
		node = deleteAtBegining(node);
		node = insertAtBegining(node, 2);
		node = insertAtBegining(node, 3);
		print(node);
		node = insertAtEnd(node, 4);
		node = insertAtEnd(node, 5);
		print(node);
		node = insertAtIndex(node, 6, 2);
		node = deleteAtEnd(node);
		print(node);
		node = deleteAtIndex(node, 2);
		print(node);
		insertAtBegining(node, 7);
		print(node);
	}
	
}
