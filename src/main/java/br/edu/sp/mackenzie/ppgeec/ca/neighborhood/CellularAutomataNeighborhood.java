package br.edu.sp.mackenzie.ppgeec.ca.neighborhood;

import br.edu.sp.mackenzie.ppgeec.ca.state.CellularAutomataState;
import br.edu.sp.mackenzie.ppgeec.graph.Graph;

public interface CellularAutomataNeighborhood {

	public abstract CellularAutomataState[][] goToNextGeneration(CellularAutomataState[][] currentGeneration,
			Graph<CellularAutomataState> graph);

}
