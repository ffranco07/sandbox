package com.sandbox.datastructures.tree;

/**
 * @author Francisco Franco
 *
 * Java program to determine if binary tree
 * is height balanced or not
 * 
 * NOTES: 
 * 1) Node has reference to Left and Right Nodes
 * 2) Ordered search where where left <= n < right
 */

public class BinaryTreeHeightBalanced {
	public Node root;

	// A binary tree node
	private static class Node {
		public int id;
		public Node left, right;

		public Node(int d) {
			id = d;
			left = right = null;
		}
	}

	/*
	 * The function Compute the "height" of a tree. 
	 * Height is the number of nodes along the longest path 
	 * from the root node down to the farthest leaf node.
	 */
	private int height(Node node) {
		// Base case tree is empty
		if (node == null) {
			return 0;
		}
		// If tree is not empty then height = 1 + max of left
		// height and right heights */
		System.out.println("node id is: " + node.id);
		if (node.left != null)
			System.out.println("node left id is: " + node.left.id);
		if (node.right != null)
			System.out.println("node right id is: " + node.right.id);
		int counter = 1 + max(height(node.left), height(node.right));
		System.out.println("counter is: " + counter + " for node: " + node.id);
		return counter;
	}
	
	/*
	 * Returns true if binary tree with root as root is 
	 * height-balanced
	 */
	private boolean isBalanced(Node node) {
		int lh; /* for height of left subtree */
		int rh; /* for height of right subtree */

		/* If tree is empty then return true */
		if (node == null) {
			return true;
		}

		/* Get the height of left and right sub trees */
		lh = height(node.left);
		rh = height(node.right);

		// Recursion happens here
		if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
			return true;
		}

		/* If we reach here then tree is not height-balanced */
		return false;
	}

	/* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
	/* returns maximum of two integers */
	private int max(int a, int b) {
		return (a >= b) ? a : b;
	}
	
	/**
	 * Main method to execute functions above
	 */
	public static void main(String args[]) {
		BinaryTreeHeightBalanced tree = new BinaryTreeHeightBalanced();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		//tree.root.left.left.left = new Node(6);
		if (tree.isBalanced(tree.root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
}
