package sumu.learning.LinkedList.Problems;

class Node {
	int value;
	Node next;
	
	Node(int value) {
		this.value = value;
	}
}

public class ReverseALinkedList {
	
	public static Node insertAtBegining(Node node, int value) {
		Node newNode = new Node(value);
		if(node == null) return newNode;
		newNode.next = node;
		return newNode;
	}
	
	public static Node reverseLinkedList(Node node) {
		if(node == null) return null;
		Node res = null;
		while(node != null) {
			Node temp = node.next;
			node.next = res;
			res = node;
			node = temp;
		}
		return res;
	}
	
	public static void print(Node node) {
		while(node != null) {
			System.out.print(node.value + " -> ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Node node = insertAtBegining(null, 1);
		node = insertAtBegining(node, 2);
		node = insertAtBegining(node, 3);
		node = insertAtBegining(node, 4);
		print(node);
		node = reverseLinkedList(node);
		node = insertAtBegining(node, 6);
		print(node);
		
	}

}
