package br.edu.sp.mackenzie.ppgeec;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.time.DurationFormatUtils;

import br.edu.sp.mackenzie.ppgeec.ca.CellularAutomata;
import br.edu.sp.mackenzie.ppgeec.ca.neighborhood.MooreNeighborhoodParallel;
import br.edu.sp.mackenzie.ppgeec.ca.neighborhood.MooreNeighborhood;
import br.edu.sp.mackenzie.ppgeec.ca.simulation.SimulationCase;
import br.edu.sp.mackenzie.ppgeec.ca.simulation.SimulationCaseFactory;
import br.edu.sp.mackenzie.ppgeec.ca.state.CellularAutomataState;
import br.edu.sp.mackenzie.ppgeec.ca.state.CellularAutomataStateFactor;
import br.edu.sp.mackenzie.ppgeec.graph.Graph;
import br.edu.sp.mackenzie.ppgeec.study.Constants;
import br.edu.sp.mackenzie.ppgeec.study.TwoDiasesGraphGenerator;
import br.edu.sp.mackenzie.ppgeec.study.TwoDiasesState;
import br.edu.sp.mackenzie.ppgeec.study.TwoDiasesValue;

public class Main {

	public static void main(String[] args) throws Exception {

		
		Instant start = Instant.now();

		Map<Double, List<SimulationCase>> casesMap = SimulationCaseFactory.createAllCases();
		List<SimulationCase> cases = casesMap.get(0d);
		
//		for (SimulationCase simulationCase : cases) {
		cases.get(0).execute();
//		}
		
		Instant end = Instant.now();
		Duration between = Duration.between(start, end);
		System.out.println("\n ======= Metrica  AC ======= \n");
		System.out
				.println("Tempo de simulação: " + DurationFormatUtils.formatDuration(between.toMillis(), "HH:mm:sss"));

	}

}
