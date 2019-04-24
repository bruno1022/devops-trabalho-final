package com.estudos.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

	private int dist[];
	private Set<Integer> settled;
	private PriorityQueue<No> pq;
	private int V; // Number of vertices
	List<List<No>> adj;

	public Main(int V) {
		this.V = V;
		dist = new int[V];
		settled = new HashSet<Integer>();
		pq = new PriorityQueue<No>(V, new No());
	}

	// Funtion for Dijkstra's Algorithm
	public void dijkstra(List<List<No>> adj, int source) {
		this.adj = adj;

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		// Add source node to the priority queue
		pq.add(new No(source, 0));

		// Distance to the source is 0
		dist[0] = 0;
		while (settled.size() != V) {

			// remove the minimum distance node
			// from the priority queue
			int u = pq.remove().no;

			// adding the node whose distance is
			// finalized
			settled.add(u);

			e_Neighbours(u);
		}
	}

	// Function to process all the neighbours
	// of the passed node
	private void e_Neighbours(int u) {
		int edgeDistance = -1;
		int newDistance = -1;

		// All the neighbors of v
		for (int i = 0; i < adj.get(u).size(); i++) {
			No v = adj.get(u).get(i);

			// If current node hasn't already been processed
			if (!settled.contains(v.no)) {
				edgeDistance = v.custo;
				newDistance = dist[u] + edgeDistance;

				// If new distance is cheaper in custo
				if (newDistance < dist[v.no])
					dist[v.no] = newDistance;

				// Add the current node to the queue
				pq.add(new No(v.no, dist[v.no]));
			}
		}
	}

	// Principal
	public static void main(String arg[]) {
		int V = 5;
		int source = 0;

		// Adjacency list representation of the
		// connected edges
		List<List<No>> adj = new ArrayList<List<No>>();

		// Initialize list for every node
		for (int i = 0; i < V; i++) {
			List<No> item = new ArrayList<No>();
			adj.add(item);
		}

		// Configuração do grafo
		//A = 0
		adj.get(0).add(new No(1, 185));
		adj.get(0).add(new No(2, 119));
		adj.get(0).add(new No(3, 152));
		adj.get(0).add(new No(4, 133));
		
		adj.get(1).add(new No(2, 121));
		adj.get(1).add(new No(3, 150));
		adj.get(1).add(new No(4, 200));

		adj.get(2).add(new No(3, 174));
		adj.get(2).add(new No(4, 120));
		
		adj.get(3).add(new No(4, 199));

		// Calculate the single source shortest path
		Main dpq = new Main(V);
		dpq.dijkstra(adj, source);

		// Print the shortest path to all the nodes
		// from the source node
		System.out.println("The shorted path from node :");
		for (int i = 0; i < dpq.dist.length; i++) {
			System.out.println(source + " to " + i + " is " + dpq.dist[i]);
		}
	}
}