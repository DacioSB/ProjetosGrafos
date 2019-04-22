package astrograph;

import org.jgrapht.Graph;
import org.jgrapht.generate.ComplementGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.io.CSVFormat;

import util.MyJGraphTUtil;

public class Astronautas {

	public static void main(String[] args) {
		Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

		graph = MyJGraphTUtil.importGraphCSV(graph, "./src/util/astronautas.csv", CSVFormat.MATRIX, false, false, true); 
		
		System.out.println("Lista de astronautas: " + graph.vertexSet());
		//System.out.println("Arestas: " + graph.edgeSet());
		
		Graph<String, DefaultEdge> complement = new SimpleGraph<>(DefaultEdge.class);

        ComplementGraphGenerator<String, DefaultEdge> cGenerator = new ComplementGraphGenerator<>(graph);

        cGenerator.generateGraph(complement);
        
        System.out.println("Pares de astronautas possiveis: " + complement.edgeSet());	

	}

}
