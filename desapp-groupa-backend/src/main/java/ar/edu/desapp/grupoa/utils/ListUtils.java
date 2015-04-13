package ar.edu.desapp.grupoa.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
	public static <E> void addIfNotExist(List<E> list, E element) {
		if(!list.contains(element)) {
			list.add(element);
		}
	}
	
	public static <E> void addWhatNotExist(List<E> list, List<E> addList) {
		for(E element : addList) {
			addIfNotExist(list, element);
		}
	}
	
	public static <E> List<E> intersection(List<E> list1, List<E> list2) {
		List<E> intersection = new ArrayList<E>();
		for(E element : list1) {
			if(list2.contains(element)) {
				intersection.add(element);
			}
		}
		return intersection;
	}
}
