package br.edu.sp.mackenzie.ppgeec.ca.simulation;

import java.util.Set;

import br.edu.sp.mackenzie.ppgeec.ca.CellularAutomata;
import br.edu.sp.mackenzie.ppgeec.ca.neighborhood.MooreNeighborhood;
import br.edu.sp.mackenzie.ppgeec.ca.neighborhood.MooreNeighborhoodParallel;
import br.edu.sp.mackenzie.ppgeec.ca.state.CellularAutomataState;
import br.edu.sp.mackenzie.ppgeec.ca.state.CellularAutomataStateFactor;
import br.edu.sp.mackenzie.ppgeec.study.Constants;
import br.edu.sp.mackenzie.ppgeec.study.TwoDiasesGraphGenerator;
import br.edu.sp.mackenzie.ppgeec.study.TwoDiasesState;
import br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue;

public class SimulationCase {

	private String name;
	private SimulationCaseData data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SimulationCaseData getData() {
		return data;
	}

	public void setData(SimulationCaseData data) {
		this.data = data;
	}

	public void execute() {

		CellularAutomataStateFactor<TwoDiasesValue, TwoDiasesState> factor = new CellularAutomataStateFactor<>(
				TwoDiasesValue.class, TwoDiasesState.class);
		Set<CellularAutomataState> values = factor.generateStates();

		CellularAutomata ca = new CellularAutomata(Constants.COLUMNS, Constants.ROWS,
				new MooreNeighborhoodParallel(Constants.RADIUS), values);
		ca.nextGeneration(TwoDiasesGraphGenerator.getGraph(data), Constants.TIME);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimulationCase other = (SimulationCase) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

}
