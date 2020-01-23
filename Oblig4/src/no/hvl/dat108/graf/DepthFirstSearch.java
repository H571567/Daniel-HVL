/**
 * 
 */
package no.hvl.dat108.graf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author tdoy
 *
 */
public class DepthFirstSearch {

	private String source;
	private Graph graph;

	public DepthFirstSearch(Graph graph, String source) {

		this.graph = graph;
		this.source = source;
	}

	public Set<String> doDepthFirstSearch() {

		Set<String> visited = new LinkedHashSet<String>();
		Stack<String> stack = new Stack<String>();

		stack.push(source);

		while (!stack.isEmpty()) {
			
			String current = stack.pop();
			
			if (!visited.contains(current)) {
				visited.add(current);
				
				for (Node node : graph.getAdjacentNodes(current)) {
					
					stack.push(node.getName());
				}
			}
		}

		return visited;
	}

	public Set<String> doDepthFirstSearchRecursive() {

		Set<String> visited = new LinkedHashSet<String>();
		List<Node> nodes = new ArrayList<Node>(graph.getAdjNodes().keySet());

		// use nodes
		Node src = nodes.get(nodes.indexOf(new Node(source)));

		// call dfsRecursive method here
		dfsRecursive(nodes, src, visited);

		return visited;
	}

	public void dfsRecursive(List<Node> nodes, Node src, Set<String> visited) {

		visited.add(src.getName());

		
		for (Node node : graph.getAdjacentNodes(src.getName())) {
			if (!visited.contains(node.getName())) {
				dfsRecursive(nodes, node, visited);
			}
		}

	}

}
