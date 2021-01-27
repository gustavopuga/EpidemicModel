package br.edu.sp.mackenzie.ppgeec.ca.neighborhood.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.jzy3d.plot3d.rendering.canvas.VoidCanvas;

import br.edu.sp.mackenzie.ppgeec.ca.state.CellularAutomataState;
import br.edu.sp.mackenzie.ppgeec.graph.Graph;

public class NeighborhoodAction implements Callable<Void> {

	private CellularAutomataState[][] currentGeneration;
	private CellularAutomataState[][] nextGeneration;
	private Graph<CellularAutomataState> graph;
	private int x;
	private int y;
	private int columns;
	private int rows;
	private int radius;

	public NeighborhoodAction(CellularAutomataState[][] currentGeneration, CellularAutomataState[][] nextGeneration,
			Graph<CellularAutomataState> graph, int radius, int x, int y) {

		this.currentGeneration = currentGeneration;
		this.nextGeneration = nextGeneration;
		this.graph = graph;
		this.radius = radius;
		this.x = x;
		this.y = y;
		this.columns = currentGeneration.length;
		this.rows = currentGeneration[0].length;
	}

	private int calculateNeighborhoodIndex(int length, int matrixIndex, int radiusIndex) {

		int indexNeighborhood = (matrixIndex + radiusIndex + length) % length;
		int index = matrixIndex + radiusIndex;

		if (index < 0) {
			index = length + index;
		} else if (index >= length) {
			index = index - length;
		}

		if (indexNeighborhood != index) {
			System.out.println(">>>>>>>> " + (indexNeighborhood == index));
		}

		return index;
	}

	@Override
	public Void call() throws Exception {
		
		List<CellularAutomataState> neighborhood = new ArrayList<>();
		for (int i = -radius; i <= radius; i++) {
			for (int j = -radius; j <= radius; j++) {

				int xNeighborhood = calculateNeighborhoodIndex(columns, x, i);
				int yNeighborhood = calculateNeighborhoodIndex(rows, y, j);

				if (x != xNeighborhood && yNeighborhood != y) {
					neighborhood.add(currentGeneration[xNeighborhood][yNeighborhood]);
				}
			}

		}

		CellularAutomataState cell = currentGeneration[x][y];
		nextGeneration[x][y] = cell.applyRule(neighborhood, graph);
		
		return null;
	}

}
