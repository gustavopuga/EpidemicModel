package br.edu.sp.mackenzie.ppgeec.study;

import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.I;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.I1;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.I12;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.I2;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.I21;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.R1;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.R2;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.S;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.V;

import java.util.List;
import java.util.Random;

import br.edu.sp.mackenzie.ppgeec.ca.state.CellularAutomataState;
import br.edu.sp.mackenzie.ppgeec.ca.state.CellularAutomataStateFactor;
import br.edu.sp.mackenzie.ppgeec.graph.Graph;

public class TwoDiasesState implements CellularAutomataState {

	private int value;
	private String description;
	private String symbol;
	private double populationPercentage;

	private CellularAutomataStateFactor<TwoDiasesValue, TwoDiasesState> factor;

	public TwoDiasesState() {
		this.factor = new CellularAutomataStateFactor<>(TwoDiasesValue.class, TwoDiasesState.class);
	}

	public double getPopulationPercentage() {
		return populationPercentage;
	}

	public void setPopulationPercentage(double populationPercentage) {
		this.populationPercentage = populationPercentage;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public CellularAutomataState applyRule(List<CellularAutomataState> neighborhood,
			Graph<CellularAutomataState> graph) {

		double n = 0;
		TwoDiasesState s = factor.createState(S);
		TwoDiasesState i1 = factor.createState(I1);
		TwoDiasesState i12 = factor.createState(I12);
		TwoDiasesState i2 = factor.createState(I2);
		TwoDiasesState i21 = factor.createState(I21);
		TwoDiasesState i = factor.createState(I);
//		TwoDiasesState r1 = factor.createState(R1);
//		TwoDiasesState r2 = factor.createState(R2);
//		TwoDiasesState r = factor.createState(R);
		TwoDiasesState v = factor.createState(V);

		Random random = new Random();

		if (s.equals(this)) {

			// AVALIA PROBABILIDADE DE INFECCAO
			double d1 = countNeighborByState(neighborhood, i1, i12);
			double d2 = countNeighborByState(neighborhood, i2, i21, i);

			if (!(d1 == 0 && d2 == 0)) {
				double x = xProbability(d1, d2);
				double randomProbability = random.nextDouble();

				// APLICA P1
				if (randomProbability < x) {
					if (random.nextDouble() < graph.getEdgeValue(this, i1, d1)) {
						return i1;
					}
				}
				// APLICA P2
				else if (randomProbability >= x) {
					if (random.nextDouble() < graph.getEdgeValue(this, i2, d2)) {
						return i2;
					}
				}
			}

			// SE NAO FOI INFECTADO VACINA
			n = countNeighbors(neighborhood, n, v);
			if (random.nextDouble() < graph.getEdgeValue(this, v, n)) {
				return v.clone();
			}

		} else {
			for (CellularAutomataState state : graph.getVertexTarget(this)) {

				n = countNeighbors(neighborhood, n, state);
				if (random.nextDouble() < graph.getEdgeValue(this, state, n)) {
					return state.clone();
				}
			}
		}

		return this;
	}

	private double xProbability(double d1, double d2) {
		return d1 / (d1 + d2);
	}

	private double countNeighbors(List<CellularAutomataState> neighborhood, double n, CellularAutomataState state) {

		TwoDiasesState s = factor.createState(S);
		TwoDiasesState i1 = factor.createState(I1);
		TwoDiasesState i12 = factor.createState(I12);
		TwoDiasesState i2 = factor.createState(I2);
		TwoDiasesState i21 = factor.createState(I21);
		TwoDiasesState i = factor.createState(I);
		TwoDiasesState r1 = factor.createState(R1);
		TwoDiasesState r2 = factor.createState(R2);
//		TwoDiasesState r = factor.createState(R);
		TwoDiasesState v = factor.createState(V);

		if (s.equals(this)) {

			if (i1.equals(state)) {
				n = countNeighborByState(neighborhood, i1, i12);
			} else if (i2.equals(state)) {
				n = countNeighborByState(neighborhood, i2, i21, i);
			}

		} else if (r1.equals(this) && i21.equals(state)) {

			n = countNeighborByState(neighborhood, i2, i21, i);

		} else if (r2.equals(this) && i12.equals(state)) {

			n = countNeighborByState(neighborhood, i1, i12);

		} else if (v.equals(this) && i.equals(state)) {

			n = countNeighborByState(neighborhood, i2, i21, i);
		}

		return n;
	}

	private long countNeighborByState(List<CellularAutomataState> neighborhood, TwoDiasesState... diasesState) {
		long n = 0;
		for (TwoDiasesState diaseState : diasesState) {
			n += countNeighborByState(neighborhood, diaseState);
		}
		return n;
	}

	private long countNeighborByState(List<CellularAutomataState> neighborhood, TwoDiasesState diaseState) {
		return neighborhood.stream().filter(n -> diaseState.equals(n)).count();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + value;
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
		TwoDiasesState other = (TwoDiasesState) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
	@Override
	public CellularAutomataState clone() {
		CellularAutomataState clone = null;
		try {
			clone = (CellularAutomataState) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

	@Override
	public String toString() {
		return symbol;
	}

}