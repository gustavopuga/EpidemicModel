package br.edu.sp.mackenzie.ppgeec.ca.neighborhood;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;

import br.edu.sp.mackenzie.ppgeec.ca.neighborhood.callable.NeighborhoodAction;
import br.edu.sp.mackenzie.ppgeec.ca.state.CellularAutomataState;
import br.edu.sp.mackenzie.ppgeec.graph.Graph;

public class MooreNeighborhoodParallel implements CellularAutomataNeighborhood {

	private int radius;

	public MooreNeighborhoodParallel(int radius) {
		this.radius = radius;
	}

	public CellularAutomataState[][] goToNextGeneration(CellularAutomataState[][] currentGeneration,
			Graph<CellularAutomataState> graph) {

		int columns = currentGeneration.length;
		int rows = currentGeneration[0].length;

		ForkJoinPool commonPool = ForkJoinPool.commonPool();

		CellularAutomataState[][] nextGeneration = new CellularAutomataState[columns][rows];

		List<Callable<?>> tasks = new ArrayList<>();
		for (int x = 0; x < columns; x++) {
			for (int y = 0; y < rows; y++) {
				NeighborhoodAction actions = new NeighborhoodAction(currentGeneration, nextGeneration, graph, radius, x, y);
				tasks.add(actions);
			}
		}

		commonPool.invokeAll(tasks);

		return nextGeneration;
	}

}
