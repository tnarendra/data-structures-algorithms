package com.naren.practice.hr;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GameTheory {

	private static class Node {
		final int id;
		final List<Node> linkedNodes = new LinkedList<>();

		private Node(int id) {
			this.id = id;
		}

		private void addLinkedNode(Node node) {
			linkedNodes.add(node);
		}

		private List<Node> getLinkedNodes() {
			return linkedNodes;
		}
	}

	private static int calculateDistance(int N, Node node1, Node node2) {
		// If any of node is null, input nodes are not connected and we return
		// -1.
		if (node1 == null || node2 == null) {
			return -1;
		}
		// Sets edge length to 6 as mentioned in challenge
		final int edgeLength = 6;

		// Applies breadth first search (level order traversal) using two queues
		// for
		// traversing alternate levels starting from level 0 means node1
		int level = 0;

		// Uses LinkedList as queues since it implements Queue interface and
		// provides implementation
		// for queue methods.
		final Queue<Node> firstQueue = new LinkedList<>();
		final Queue<Node> secondQueue = new LinkedList<>();

		// Adds node1 to first queue to start loop
		firstQueue.offer(node1);

		// An array to keep note of visited nodes
		final boolean[] visitedNodes = new boolean[N];

		while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
			while (!firstQueue.isEmpty()) {
				final Node tmpNode = firstQueue.poll();
				// Ignore the visited nodes
				if (visitedNodes[tmpNode.id]) {
					continue;
				}

				if (tmpNode.id == node2.id) {
					return level * edgeLength;
				}

				// mark the current node as visited
				visitedNodes[tmpNode.id] = true;
				// add all linked nodes of this node to second queue to traverse
				// after current
				// queue nodes (this level) have been visited
				secondQueue.addAll(tmpNode.getLinkedNodes());
			}
			// Increment the level as we move to next level after we have
			// traversed all the elements of a queue
			level++;

			while (!secondQueue.isEmpty()) {
				final Node tmpNode = secondQueue.poll();
				// Ignore the visited nodes
				if (visitedNodes[tmpNode.id]) {
					continue;
				}

				if (tmpNode.id == node2.id) {
					return level * edgeLength;
				}
				// mark the current node as visited
				visitedNodes[tmpNode.id] = true;
				// add all linked nodes of this node to first queue to traverse
				// after current
				// queue nodes (this level) have been visited
				firstQueue.addAll(tmpNode.getLinkedNodes());
			}
			// Increment the level as we move to next level after we have
			// traversed all the elements of a queue
			level++;
		}

		return -1;
	}

	/**
	 * We will be using adjacency list model wherein each node will be
	 * containing the list of other nodes, it is linked to.
	 */
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		// Get no of test cases
		final int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			// For each test case
			// Get no of nodes in graph
			final int N = in.nextInt();
			// Get no of edges
			final int M = in.nextInt();
			// Array for storing all the elements of graph. Elements that are
			// not connected are not stored in this array
			final Node[] graphElems = new Node[N];
			for (int j = 0; j < M; j++) {
				// Subtract 1 out of first node id to fit this into our graph
				// elements as array index starts with 0
				final int x = in.nextInt() - 1;
				// If node is present in array, fetch it, otherwise create a new
				// instance of Node and put in array
				Node xNode = graphElems[x];
				if (xNode == null) {
					xNode = new Node(x);
					graphElems[x] = xNode;
				}

				// Subtract 1 out of second node id to fit this into our graph
				// elements as array index starts with 0
				final int y = in.nextInt() - 1;
				// If node is present in array, fetch it, otherwise create a new
				// instance of Node and put in array
				Node yNode = graphElems[y];
				if (yNode == null) {
					yNode = new Node(y);
					graphElems[y] = yNode;
				}
				// Since graph is undirected, we set both nodes into each
				// other's linked nodes to have a bi-directional mapping
				xNode.addLinkedNode(yNode);
				yNode.addLinkedNode(xNode);
			}

			// Subtract 1 out of start node id to fit this into our graph
			// elements as array index starts with 0
			final int S = in.nextInt() - 1;
			for (int k = 0; k < graphElems.length; k++) {
				if (k != S) {
					int distance = calculateDistance(N, graphElems[k], graphElems[S]);
					System.out.print(distance + " ");
				}
			}
			System.out.println();
		}
		in.close();
	}
}