package ar.edu.desapp.groupa.model.utils;

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
	
	public static <E> List<E> getFirsts(List<E> list, Integer amount) {
		List<E> result = new ArrayList<E>();
		if(list.size() <= amount) {
			result = list;
		} else {
			for(Integer i=0; i<amount; i++) {
				result.add(list.get(i));
			}
		}
		return result;
	}
}
