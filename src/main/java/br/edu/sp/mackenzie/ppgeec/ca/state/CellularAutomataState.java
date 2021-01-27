package br.edu.sp.mackenzie.ppgeec.ca.state;

import java.util.List;

import br.edu.sp.mackenzie.ppgeec.graph.Graph;

public interface CellularAutomataState extends Cloneable {

	public abstract void setValue(int value);

	public abstract int getValue();

	public abstract void setDescription(String description);

	public abstract String getDescription();

	public abstract void setSymbol(String symbol);

	public abstract String getSymbol();

	public abstract void setPopulationPercentage(double populationPercentage);

	public abstract double getPopulationPercentage();

	public abstract CellularAutomataState clone();

	public abstract CellularAutomataState applyRule(List<CellularAutomataState> neighborhood,
			Graph<CellularAutomataState> graph);

}