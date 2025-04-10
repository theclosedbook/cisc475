package problem4;

public class Test1 {
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph();
		Node n0 = graph.addNode(), n1 = graph.addNode(), n2 = graph.addNode();
		graph.addEdge(n0, n1);
		graph.addEdge(n1, n2);
		graph.addEdge(n0, n2);
		graph.addEdge(n2, n0);
		graph.addEdge(n2, n0); // adding twice shouldn't do anything
		graph.print(System.out);
		// should add some checks here using assert...
	}
}
