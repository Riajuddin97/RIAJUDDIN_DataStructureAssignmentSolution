package com.greatlearning.assigment3.Q2;

import com.greatlearning.assigment3.Q2.BinaryTreeData.Node;
import com.greatlearning.assigment3.Q2.BinaryTreeData.RootNode;

public class TransactionsDataDriver {

	// Driver Code
	public static void main(String[] args) {
		System.out.println("Transaction DATA after Converting into Binary Search tree ");
		System.out.println("\n==============================");
		RootNode.node = new Node(50);
		RootNode.node.left = new Node(30);
		RootNode.node.right = new Node(60);
		RootNode.node.left.left = new Node(10);
		RootNode.node.right.left = new Node(55);

		// Order of the Skewed tree can be defined as follows - 
		// For Increasing order - 0
		// For Decreasing order - 1
		int order = 0;
		RootNode.flattenBTToSkewed(RootNode.node, order);
		RootNode.inOrderTraversalOfSkewedTree(RootNode.headNode);
		System.out.println("\n==============================");

	}
}
