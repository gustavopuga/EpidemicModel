package br.edu.sp.mackenzie.ppgeec.ca.simulation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimulationCaseFactory {

	public static Map<Double, List<SimulationCase>> createAllCases() {

		List<Double> vacinationPercentualList = IntStream.rangeClosed(0, 100).mapToDouble(i -> i / 100d).boxed()
				.collect(Collectors.toList());

		double ks = 1d;
		double epsilons = 0.1d;
		double betas = 0.3d;
		double gammas = 0.2d;

		double[] beta2s = { 0.3d, 0.2d, 0.15d, 0.12d, 0.1d };
		double[] gamma2s = { 0.2d, 0.3d, 0.4d, 0.5d, 0.6d };

		Map<Double, List<SimulationCase>> caseMap = new LinkedHashMap<>();
		int index = 1;
		for (Double v : vacinationPercentualList) {
			List<SimulationCase> cases = new ArrayList<>();
			for (double gamma2 : gamma2s) {
				for (double beta2 : beta2s) {
					SimulationCaseData data = new SimulationCaseData();
					data.setB1(betas);
					data.setB2(betas);
					data.setBeta(betas);
					data.setBeta1(betas);
					data.setBeta2(beta2);

					data.setC1(gammas);
					data.setC2(gammas);
					data.setGamma(gammas);
					data.setGamma1(gammas);
					data.setGamma2(gamma2);

					data.setE(epsilons);
					data.setE1(epsilons);
					data.setE2(epsilons);
					data.setEpsilon(epsilons);

					data.setK1(ks);
					data.setK2(ks);
					data.setK3(ks);
					data.setK4(ks);
					data.setK5(ks);

					data.setV(v);

					SimulationCase simulationCase = new SimulationCase();
					simulationCase.setData(data);
					simulationCase.setName("Simulação " + index);

					cases.add(simulationCase);
					index++;
				}
				caseMap.put(v, cases);
			}
		}
		return caseMap;
	}
}
