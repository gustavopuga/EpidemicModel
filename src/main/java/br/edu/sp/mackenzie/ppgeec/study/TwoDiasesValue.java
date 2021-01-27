package br.edu.sp.mackenzie.ppgeec.study;

import br.edu.sp.mackenzie.ppgeec.ca.values.CellularAutomataValues;

public enum TwoDiasesValue implements CellularAutomataValues {

	S(0, "Suscetível as doenças", "S", 0.98),
	I1(1, "Infectado por 1 / nunca contraiu 2", "I\u2081", 0.01),
	I2(2, "Infectado por 2 / nunca contraiu 1", "I\u2082", 0.01), 
	I12(3, "Infectado por 1 / imune a 2 porque contraiu 2", "I\u2081\u2082", 0d),
	I21(4, "Infectado por 2 / imune a 1 porque contraiu 1", "I\u2082\u2081", 0d),
	I(5, "Infectado por 2 / imune a 1 por ter sido vacinado contra 1", "I", 0d), 
	R1(6, "Imune a 1 por ter contraído 1", "R\u2081", 0d),
	R2(7, "Imune a 2 por ter contraído 2", "R\u2082", 0d), 
	R(8, "Imune as duas doenças", "R", 0d),
	V(9, "Imune a 1 por ter se vacinado contra 1", "V", 0d);
	
	private final int value;
	private final String description;
	private final String symbol;
	private final Double populationPercentage;
	
	private TwoDiasesValue(int value, String description, String symbol, Double initialPopulationPercentage) {
		this.value = value;
		this.description = description;
		this.symbol = symbol;
		this.populationPercentage = initialPopulationPercentage;
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
	public double getPopulationPercentage() {
		return populationPercentage;
	}
	
}
