package br.edu.sp.mackenzie.ppgeec.graph;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Graph<V> {

	private Map<V, Map<V, Function<Double, Double>>> map = new HashMap<>();

	public void addVertex(V s) {
		map.put(s, new LinkedHashMap<>());
	}

	public void addEdge(V source, V destination, Function<Double, Double> edgeValue) {
		this.addEdge(source, destination, edgeValue, false);
	}
	
	public void addEdge(V source, V destination, Function<Double, Double> edgeValue, boolean bidirectional) {

		if (!map.containsKey(source))
			addVertex(source);

		if (!map.containsKey(destination))
			addVertex(destination);

		map.get(source).put(destination, edgeValue);
		if (bidirectional == true) {
			map.get(destination).put(source, edgeValue);
		}
	}

	public double getEdgeValue(V source, V destination, double value) {

		return map.get(source).get(destination).apply(value);
	}
	
	public int getVertexCount() {
		return map.keySet().size();
	}

	public int getEdgesCount(boolean bidirection) {
		int count = 0;
		for (V v : map.keySet()) {
			count += map.get(v).size();
		}
		if (bidirection == true) {
			count = count / 2;
		}
		return count;
	}

	public Set<V> getVertexTarget(V source) {
		return map.get(source).keySet();
	}

	public boolean hasVertex(V source) {
		return map.containsKey(source);
	}

	public boolean hasEdge(V source, V target) {
		return map.get(source).containsKey(target);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (V source : map.keySet()) {
			builder.append(source.toString() + ": ");
			for (V target : map.get(source).keySet()) {
				builder.append(target.toString() + " ");
			}
			builder.append("\n");
		}

		return (builder.toString());
	}
}
