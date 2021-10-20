package com.greatlearning.assigment3.Q2;

class BinaryTreeData {

	// Class of the node
	 public static class Node {
		int Data;
		Node left;
		Node right;

		// Helper function that allocates a new node
		// with the given data and NULL left and right pointers.
		Node(int value) {
			Data = value;
			left = null;
			right = null;
		}
	}

	static class RootNode {
		public static Node node;
		static Node prevNode = null;
		static Node headNode = null;

		// Function to to flatten the binary search tree into a skewed tree in increasing or decreasing order

		static void flattenBTToSkewed(Node root, int order) {

			// Base Case
			if (root == null) {
				return;
			}

			// Condition to check the order in which the skewed tree to maintained
			
			if (order > 0) {
				flattenBTToSkewed(root.right, order);
			} else {
				flattenBTToSkewed(root.left, order);
			}
			Node rightNode = root.right;
			Node leftNode = root.left;

			// Condition to check if the root Node of the skewed tree is not defined
	
			if (headNode == null) {
				headNode = root;
				root.left = null;
				prevNode = root;
			} else {
				prevNode.right = root;
				root.left = null;
				prevNode = root;
			}

			/*Similarly recurse for the left / right
			 subtree on the basis of the order required */
			if (order > 0) {
				flattenBTToSkewed(leftNode, order);
			} else {
				flattenBTToSkewed(rightNode, order);
			}
		}

		// Function to traverse the right
		// skewed tree using recursion
		static void inOrderTraversalOfSkewedTree(Node root) {
			if (root == null) {
				return;
			}
			System.out.print(root.Data + " -> ");
			inOrderTraversalOfSkewedTree(root.right);
		}
	}
}
