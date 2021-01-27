package br.edu.sp.mackenzie.ppgeec.ca.state;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import br.edu.sp.mackenzie.ppgeec.ca.values.CellularAutomataValues;

public class CellularAutomataStateFactor<T extends Enum<T> & CellularAutomataValues, G extends CellularAutomataState> {

	private Class<T> classT;
	private Class<G> classG;

	public CellularAutomataStateFactor(Class<T> classT, Class<G> classG) {
		this.classT = classT;
		this.classG = classG;
	}

	public Set<CellularAutomataState> generateStates() {

		Set<CellularAutomataState> values = new HashSet<>();
		for (T t : EnumSet.allOf(classT)) {
			values.add(createState(t));
		}

		return values;
	}

	public G createState(T t) {
		synchronized (classG) {
			G g = null;

			try {
				g = classG.newInstance();
				g.setValue(t.getValue());
				g.setDescription(t.getDescription());
				g.setPopulationPercentage(t.getPopulationPercentage());
				g.setSymbol(t.getSymbol());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}

			return g;
		}
	}

}
