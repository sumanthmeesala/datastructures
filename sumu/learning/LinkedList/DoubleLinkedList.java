package sumu.learning.LinkedList;

class DoubleLinkedLink {
	int value;
	DoubleLinkedLink next;
	DoubleLinkedLink prev;
	
	DoubleLinkedLink(int value) {
		this.value = value;
	}
}

public class DoubleLinkedList {
	
	public static DoubleLinkedLink insertAtBegining(DoubleLinkedLink node, int value) {
		DoubleLinkedLink newNode = new DoubleLinkedLink(value);
		if(node == null) {
			return newNode;
		}
		newNode.prev = null;
		node.prev = newNode;
		newNode.next = node;
		node = newNode;
		return node;
	}
	
	public static DoubleLinkedLink insertAtEnd(DoubleLinkedLink node, int value) {
		DoubleLinkedLink newNode = new DoubleLinkedLink(value);
		if(node == null) {
			return newNode;
		}
		DoubleLinkedLink temp = node;
		while(temp.next != null) {
			temp = temp.next;
		}
		newNode.prev = temp;
		temp.next = newNode;
		return node;
	}
	
	public static DoubleLinkedLink insertAtIndex(DoubleLinkedLink node, int value, int index) {
		DoubleLinkedLink newNode = new DoubleLinkedLink(value);
		if(node == null) {
			return newNode;
		}
		DoubleLinkedLink curr = node;
		while(index-- > 0) {
			curr = curr.next;
		}
		newNode.next = curr.next;
		newNode.prev = curr;
		curr.next = newNode;
		return node;
	}
	
	public static DoubleLinkedLink deleteAtBegining(DoubleLinkedLink node) {
		if(node == null) {
			System.out.println("Nothing to delete!");
			return null;
		}
		node.next.prev = null;
		return node.next;
	}
	
	public static DoubleLinkedLink deleteAtEnd(DoubleLinkedLink node) {
		if(node == null) {
			System.out.println("Nothing to delete!");
			return null;
		}
		DoubleLinkedLink curr = node;
		while(curr.next != null) {
			curr = curr.next;
		}
		curr.prev.next = null;
		return node;
	}
	
	public static void deleteAtIndex(DoubleLinkedLink node, int index) {
		if(node == null) {
			System.out.println("Nothing to delete!");
			return;
		}
		DoubleLinkedLink curr = node;
		while(index-- > 0) {
			curr = curr.next;
		}
		curr.prev.next = curr.next;
	}
	
	public static void print(DoubleLinkedLink node) {
		if(node == null) {
			return;
		}
		while(node != null) {
			System.out.print(node.value + " <-> ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		DoubleLinkedLink node = null;
		node = insertAtBegining(node, 1);
		node = insertAtBegining(node, 2);
		node = insertAtBegining(node, 3);
		print(node);
		node = insertAtEnd(node, 4);
		node = insertAtEnd(node, 5);
		node = insertAtEnd(node, 6);
		print(node);
		node = insertAtIndex(node, 7, 2);
		node = insertAtIndex(node, 8, 3);
		print(node);
		node = deleteAtBegining(node);
		print(node);
		node = deleteAtEnd(node);
		print(node);
		deleteAtIndex(node, 2);
		print(node);
	}
	
}
