package br.edu.sp.mackenzie.ppgeec.study;

import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.I;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.I1;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.I12;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.I2;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.I21;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.R;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.R1;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.R2;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.S;
import static br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue.V;

import br.edu.sp.mackenzie.ppgeec.ca.simulation.SimulationCaseData;
import br.edu.sp.mackenzie.ppgeec.ca.state.CellularAutomataState;
import br.edu.sp.mackenzie.ppgeec.ca.state.CellularAutomataStateFactor;
import br.edu.sp.mackenzie.ppgeec.graph.Graph;

public class TwoDiasesGraphGenerator {

	public static Graph<CellularAutomataState> getGraph(SimulationCaseData simulationCase) {

		CellularAutomataStateFactor<TwoDiasesValue, TwoDiasesState> factor = new CellularAutomataStateFactor<>(
				TwoDiasesValue.class, TwoDiasesState.class);

		TwoDiasesState s = factor.createState(S);
		TwoDiasesState i1 = factor.createState(I1);
		TwoDiasesState i12 = factor.createState(I12);
		TwoDiasesState i21 = factor.createState(I21);
		TwoDiasesState i2 = factor.createState(I2);
		TwoDiasesState i = factor.createState(I);
		TwoDiasesState r1 = factor.createState(R1);
		TwoDiasesState r2 = factor.createState(R2);
		TwoDiasesState r = factor.createState(R);
		TwoDiasesState v = factor.createState(V);

		// GRAPH
		Graph<CellularAutomataState> graph = new Graph<>();
		graph.addVertex(s);
		graph.addVertex(i1);
		graph.addVertex(i12);
		graph.addVertex(i21);
		graph.addVertex(i2);
		graph.addVertex(i);
		graph.addVertex(r1);
		graph.addVertex(r2);
		graph.addVertex(r);
		graph.addVertex(v);

		// S
		graph.addEdge(s, i1, n -> 1 - Math.pow(Math.E, -1 * simulationCase.getK1() * n));
		graph.addEdge(s, i2, n -> 1 - Math.pow(Math.E, -1 * simulationCase.getK2() * n));
		graph.addEdge(s, v, n -> simulationCase.getV());

		// I1
		graph.addEdge(i1, r1, n -> simulationCase.getB1());
		graph.addEdge(i1, s, n -> simulationCase.getC1());

		// I12
		graph.addEdge(i12, r, n -> simulationCase.getBeta1());
		graph.addEdge(i12, s, n -> simulationCase.getGamma1());

		// I21
		graph.addEdge(i21, r, n -> simulationCase.getBeta2());
		graph.addEdge(i21, s, n -> simulationCase.getGamma2());

		// I2
		graph.addEdge(i2, r2, n -> simulationCase.getB2());
		graph.addEdge(i2, s, n -> simulationCase.getC2());

		// I
		graph.addEdge(i, r, n -> simulationCase.getBeta());
		graph.addEdge(i, s, n -> simulationCase.getGamma());

		// R1
		graph.addEdge(r1, i21, n -> 1 - Math.pow(Math.E, -1 * simulationCase.getK4() * n));
		graph.addEdge(r1, s, n -> simulationCase.getE1());

		// R2
		graph.addEdge(r2, i12, n -> 1 - Math.pow(Math.E, -1 * simulationCase.getK3() * n));
		graph.addEdge(r2, s, n -> simulationCase.getE2());

		// R
		graph.addEdge(r, s, n -> simulationCase.getEpsilon());

		// V
		graph.addEdge(v, s, n -> simulationCase.getE());
		graph.addEdge(v, i, n -> 1 - Math.pow(Math.E, -1 * simulationCase.getK5() * n));

		return graph;

	}

}
