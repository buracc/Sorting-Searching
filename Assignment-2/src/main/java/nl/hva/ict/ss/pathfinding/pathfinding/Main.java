package nl.hva.ict.ss.pathfinding.pathfinding;

import nl.hva.ict.ss.pathfinding.tileworld.TileWorldUtil;
import nl.hva.ict.ss.pathfinding.weigthedgraph.EdgeWeightedDigraph;

/**
 * TODO make sure your code is compliant with the HBO-ICT coding conventions!
 * @author ???
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO Here you can do your experiments.
    	
    	// Please have a good look at the constructors of EdgeWeightedDigraph!
    	
    	// Before you save any images make sure the value of TileWorldUtil.outputDir points to an
    	// existing folder and ands with a '/'!
    	// Example: TileWorldUtil.outputDir = "/Users/nico/output/";


        TileWorldUtil.outputDir = "/Users/nico/Downloads/output/";
        System.out.printf("ID;Length Dijkstra;Length Floyd;Costs Dijkstra; Costs Floyd\n");
        for (int i = 1; i <= 21; i++) {
            // Read the graph directly from a image
            EdgeWeightedDigraph graafDijkstra = new EdgeWeightedDigraph("i" + i);
            // Get the start and end node
            final int start = graafDijkstra.getStart();
            final int finish = graafDijkstra.getEnd();

            // Run dijkstra
            final Dijkstra dijkstra = new Dijkstra(graafDijkstra, start);
            if (dijkstra.hasPathTo(finish)) {
                // Show the result
                graafDijkstra.tekenPad(dijkstra.pathTo(finish));
                // Save it
                graafDijkstra.save("i" + i + "-dijkstra");
            }
        }
    }
    
}
