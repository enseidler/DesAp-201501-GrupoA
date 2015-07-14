package ar.edu.desapp.groupa.helpers;

import static ar.edu.desapp.groupa.model.utils.ListUtils.addIfNotExist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.edu.desapp.groupa.model.comparators.DiseaseComparator;
import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.symptom.Symptom;

public class DiagnoseHelper {


	public static List<Disease> diagnose(List<Disease> diseases, List<Symptom> currentSymptoms) {
		List<Disease> possibles = possibleDiseases(diseases, currentSymptoms);
		Collections.sort(possibles, new DiseaseComparator(currentSymptoms));;
		return possibles;
	}
	
	private static List<Disease> possibleDiseases(List<Disease> diseases,List<Symptom> symptoms) {
		List<Disease> result = new ArrayList<Disease>();
		for(Disease disease : diseases) {
			if(disease.hasASymptom(symptoms)) {
				addIfNotExist(result,disease);
			}
		}
//		if(result.isEmpty()) {
//			result = diseases;
//		}
		return result;
	} 
	
}
