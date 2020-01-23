/**
 * 
 */
package no.hvl.dat108.graf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author tdoy
 *
 */
public class VertexCover {

	/**
	 * 
	 */

	private Graph graph;
	
	public VertexCover(Graph graph) {
		
		this.graph = graph;
		
	}
	
	public List<String> approxVertexCover() {
		
		List<String> approxmvc = new ArrayList<String>(); 						// set to hold our min vertex cover
		
		// collect the edges of the graph 
		Queue<Edge> queue = new LinkedList<Edge>(graph.getEdges()); 			// set of all vertices
		
		// implement me
		Set<Edge> unvisited = new HashSet<>(graph.getEdges());
		
		while (!queue.isEmpty()) {

			Edge e = queue.poll();
			String s = e.getSource();
			String d = e.getDestination();
			
			if (unvisited.contains(e)) {
				approxmvc.add(e.getSource());
				approxmvc.add(e.getDestination());
			
			
				unvisited.removeIf(edge -> edge.getSource().equals(s) || edge.getDestination().equals(s) ||
								edge.getSource().equals(d) || edge.getDestination().equals(d));
			
			}
		}
			
		return approxmvc;		
	}
	
}
