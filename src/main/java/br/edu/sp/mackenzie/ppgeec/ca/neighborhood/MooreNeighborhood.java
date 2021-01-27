package br.edu.sp.mackenzie.ppgeec.ca.neighborhood;

import java.util.ArrayList;
import java.util.List;

import br.edu.sp.mackenzie.ppgeec.ca.state.CellularAutomataState;
import br.edu.sp.mackenzie.ppgeec.graph.Graph;

public class MooreNeighborhood implements CellularAutomataNeighborhood {

	private int radius;

	public MooreNeighborhood(int radius) {
		this.radius = radius;
	}

	public CellularAutomataState[][] goToNextGeneration(CellularAutomataState[][] currentGeneration,
			Graph<CellularAutomataState> graph) {

		int columns = currentGeneration.length;
		int rows = currentGeneration[0].length;

		CellularAutomataState[][] nextGeneration = new CellularAutomataState[columns][rows];

		for (int x = 0; x < columns; x++) {
			for (int y = 0; y < rows; y++) {

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

			}
		}

		return nextGeneration;
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

}
