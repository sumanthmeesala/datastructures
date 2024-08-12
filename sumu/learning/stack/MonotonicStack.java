package sumu.learning.stack;

public class MonotonicStack {

	Node<Integer> top;
	MonotonicStack() {
		top = null;
	}
	
	public void push(Integer element) {
		Node<Integer> newNode = new Node(element);
		while(top != null && top.element > element) {
			top = top.next;
		}
		newNode.next = top;
		top = newNode;
		
	}
	
	public Integer pop() {
		if(top == null) return null;
		Integer ele = top.element;
		top = top.next;
		return ele;
	}
	
	public String toString() {
		Node<Integer> dup = top;
		StringBuilder sb = new StringBuilder();
		while(dup != null) {
			sb.append(" -> " + dup.element);
			dup = dup.next;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MonotonicStack mon = new MonotonicStack();
		mon.push(1);
		mon.push(2);
		mon.push(7);
		mon.push(3);
		System.out.println(mon);
		
	}
		
}
