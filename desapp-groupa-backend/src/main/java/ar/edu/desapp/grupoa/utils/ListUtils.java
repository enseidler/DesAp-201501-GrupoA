package ar.edu.desapp.grupoa.utils;

import java.util.List;

public class ListUtils {
	public static <E> void addIfNotExist(List<E> list, E element) {
		if(!list.contains(element)) {
			list.add(element);
		}
	}
}
