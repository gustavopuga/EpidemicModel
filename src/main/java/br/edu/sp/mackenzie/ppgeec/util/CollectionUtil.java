package br.edu.sp.mackenzie.ppgeec.util;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtil {

	public static <T> List<List<T>> create2DList(int rows, int columns) {
	
		List<List<T>> list = new ArrayList<List<T>>();
		for (int i = 0; i < rows; i++) {
			list.add(new ArrayList<>(columns));
		}
		return list;
	}
	
}
