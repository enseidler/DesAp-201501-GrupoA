package ar.edu.desapp.groupa.model.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.collections4.CollectionUtils;

import ar.edu.desapp.groupa.entity.Entity;
import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.symptom.Symptom;


public class FaceMedUtils {
	
	public static List<Symptom> intersection(List<Symptom> list, List<Symptom> list2) {
		List<Symptom> intersection = new ArrayList<Symptom>();
		for(Symptom element1 : list) {
			for(Symptom element2 : list2) {
				if(element1.sameId(element2)) {
					intersection.add(element2);
				}
			}
		}
		return intersection;
	}
	
	public static List<Integer> getIntsFromString(String string) {
		Scanner scanner = new Scanner(string);
		List<Integer> list = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
		    list.add(scanner.nextInt());
		}
		return list;
	}
	
	public static <T> List<Integer> getIdsFromEntitys(List<T> list) {
		List<Integer> result = new ArrayList<Integer>();
		for(T entity : list) {
			result.add(((Entity) entity).getId());
		}
		return result;
	}
	
	public static Integer matchs(Disease disease, List<Symptom> symptoms) {
		return (intersection(disease.getSymptoms(), symptoms)).size();
//		return CollectionUtils.intersection(disease.getSymptoms(), symptoms).size();
	}
	
}
