package sumu.learning.queue;

import java.util.Arrays;

public class PriorityQueue {
	
	int[] queue;
	int size;
	int latestIndex = -1;
	
	PriorityQueue(int size) {
		queue = new int[size];
	}
	
	private int getParent(int i) {
		return (i - 1) / 2;
	}
	
	private int getLeftChild(int i) {
		int index = (2 * i) + 1;
		int value = index < latestIndex ? (2 * i) + 1 : -1;
		return value;
	}
	
	private int getRightChild(int i) {
		int index = (2 * i) + 2;
		int value = index < latestIndex ? (2 * i) + 2 : -1;
		return value;
	}
	
	private void shiftUp(int i) {
		while(queue[i] > queue[getParent(i)]) {
			int temp = queue[i];
			queue[i] = queue[getParent(i)];
			queue[getParent(i)] = temp;
			i = getParent(i);
		}
	}
	
	private int getMaxIndexOfChildren(int i) {
		int leftChild = getLeftChild(i);
		int rightChild = getRightChild(i);
		if(leftChild != -1 && rightChild != -1) {
			int maxIndex = queue[leftChild] < queue[rightChild] ? rightChild : leftChild;
			return maxIndex;
		}
		if(leftChild == -1 && rightChild != -1) {
			return queue[rightChild];
		}
		if(leftChild != -1 && rightChild == -1) {
			return queue[leftChild];
		}
		return -1;
	}
	
	private void shiftDown(int i) {
		int maxIndex = getMaxIndexOfChildren(i);
		while(maxIndex != -1 && queue[i] < queue[maxIndex] && maxIndex != i) {
			int temp = queue[i];
			queue[i] = queue[maxIndex];
			queue[maxIndex] = temp;
			i = maxIndex;
			maxIndex = getMaxIndexOfChildren(i);
		}
	}
	
	private void enQueue(int element) {
		latestIndex++;
		queue[latestIndex] = element;
		shiftUp(latestIndex);
	}
	
	private int deQueue() {
		if(latestIndex == -1) {
			System.out.println("No elements to remove");
			return -1;
		}
		int element = queue[0];
		int temp = queue[latestIndex];
		queue[latestIndex] = queue[0];
		queue[0] = temp;
		shiftDown(0);
		latestIndex--;
		return element;
	}
	
	private void print() {
		for(int i = 0; i <= latestIndex; i++) {
			System.out.print(queue[i] + " ");
		}
		System.out.println();
	}
	
	private void printElements() {
		System.out.println(Arrays.toString(queue));
	}
	
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue(10);
		pq.enQueue(1);
		pq.enQueue(2);
		pq.enQueue(3);
		pq.enQueue(4);
		pq.enQueue(5);
		pq.enQueue(6);
		pq.print();
		System.out.println(pq.deQueue());
		System.out.println(pq.deQueue());
		System.out.println(pq.deQueue());
		System.out.println(pq.deQueue());
		System.out.println(pq.deQueue());
		System.out.println(pq.deQueue());
		System.out.println(pq.deQueue());
		pq.printElements();
	}
	
}
