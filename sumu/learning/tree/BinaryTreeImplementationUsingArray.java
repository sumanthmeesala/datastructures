package sumu.learning.tree;

import java.util.Arrays;
import java.util.Stack;

public class BinaryTreeImplementationUsingArray<T> {
	T[] tree;
	int index;
	
	BinaryTreeImplementationUsingArray(int size) {
		tree = (T[]) new Object[size];
		index = -1;
	}
	
	public void insert(T element) {
		index++;
		tree[index] = element;
	}
	
	public void insertLeftForParentIndex(int index, T element) {
		if(tree[index] != null && tree[index * 2 + 1] == null) {
			tree[index * 2 + 1] = element;
			System.out.println(element +  " inserted Successfully!");
			this.index++;
			return;
		}
		System.out.println("Insertion failed");
	}
	
	public void insertRightForParentIndex(int index, T element) {
		if(tree[index] != null && tree[index * 2 + 2] == null) {
			tree[index * 2 + 2] = element;
			this.index++;
			System.out.println(element +  " inserted Successfully!");
			return;
		}
		System.out.println("Insertion failed");
	}
	
	public int findIndexOfParent(T parent) {
		for(int i = 0; i <= index; i++) {
			if(tree[i] == parent) {
				return i;
			}
		}
		return -1;
	}
	
	public void insertLeftForParent(T parent, T element) {
		int indexOfParent = findIndexOfParent(parent);
		if(indexOfParent == -1) {
			System.out.println("Parent not found!");
			return;
		}
		insertLeftForParentIndex(indexOfParent, element);
	}
	
	public void insertRightForParent(T parent, T element) {
		int indexOfParent = findIndexOfParent(parent);
		if(indexOfParent == -1) {
			System.out.println("Parent not found!");
			return;
		}
		insertRightForParentIndex(indexOfParent, element);
	}
	
	public void preOrderTraversal(int index) {
		if(tree[index] == null) {
			return;
		}
		System.out.print(tree[index] + " ");
		preOrderTraversal(2 * index + 1);
		preOrderTraversal(2 * index + 2);
	}
	
	public void preOrderUsingIterative(int index) {
		Stack<Integer> stk = new Stack<>();
		stk.push(index);
		while(!stk.isEmpty()) {
			int element = stk.pop();
			System.out.print(tree[element] + " ");
			if(tree[element * 2 + 2] != null) {
				stk.push(element * 2 + 2);
			}
			if(tree[element * 2 + 1] != null) {
				stk.push(element * 2 + 1);
			}
		}
	}
	
	public void inorderRecursive(int index) {
		if(tree[index] == null) return;
		inorderRecursive(2 * index + 1);
		System.out.print(tree[index] + " ");
		inorderRecursive(2 * index + 2);
	}
	
	public void inorderIterative(int index) {
		Stack<Integer> stk = new Stack<>();
		while (!stk.isEmpty() || tree[index] != null) {
			while (tree[index] != null) {
				stk.push(index);
				index = index * 2 + 1;
			}
			int ind = stk.pop();
			T element = tree[ind];
			System.out.print(element + " ");
			index = 2 * ind + 2;
		}
	}
	
	public void postOrderRecursive(int index) {
		if(tree[index] == null) return;
		postOrderRecursive(index * 2 + 1);
		postOrderRecursive(index * 2 + 2);
		System.out.print(tree[index] + " ");
	}
	
	public void postOrderIterative(int index) {
		Stack<Integer> stk1 = new Stack<>();
		Stack<Integer> stk2 = new Stack<>();
		stk1.push(index);
		while(!stk1.isEmpty()) {
			int ind = stk1.pop();
			stk2.push(ind);
			if(tree[ind * 2 + 1] != null) {
				stk1.push(ind * 2 + 1);
			}
			if(tree[ind * 2 + 2] != null) {
				stk1.push(ind * 2 + 2);
			}
		}
		while(!stk2.isEmpty()) {
			System.out.print(tree[stk2.pop()] + " ");
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeImplementationUsingArray<Integer> binaryTree = new BinaryTreeImplementationUsingArray<>(
				20);
		binaryTree.insert(1);
		binaryTree.insertLeftForParent(1, 2);
		binaryTree.insertRightForParent(1, 3);
		binaryTree.insertLeftForParent(2, 4);
		binaryTree.insertRightForParent(2, 5);
		binaryTree.insertLeftForParent(3, 6);
		binaryTree.insertRightForParent(3, 7);
		System.out.println(Arrays.toString(binaryTree.tree));
		binaryTree.preOrderTraversal(0);
		System.out.println();
		binaryTree.preOrderUsingIterative(0);
		System.out.println();
		binaryTree.inorderRecursive(0);
		System.out.println();
		binaryTree.inorderIterative(0);
		System.out.println();
		binaryTree.postOrderRecursive(0);
		System.out.println();
		binaryTree.postOrderIterative(0);
	}

}
