package ar.edu.desapp.groupa.model.comparators;

import static ar.edu.desapp.groupa.model.utils.FaceMedUtils.matchs;
import static ar.edu.desapp.groupa.model.utils.FaceMedUtils.intersection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import ar.edu.desapp.groupa.entity.Entity;
import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.symptom.Symptom;

public class DiseaseComparator implements Comparator<Disease> {

	private List<Symptom> symptoms;
	
	public DiseaseComparator() {
		
	}
	
	public DiseaseComparator(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}
	
	public List<Symptom> getSymptoms() {
		return symptoms;
	}
	
	public void setSymptoms(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}
	
	@Override
	public int compare(Disease disease1, Disease disease2) {
		Integer matchsDisease1 = matchs(disease1, this.getSymptoms());
		Integer matchsDisease2 = matchs(disease2, this.getSymptoms());
		for(Symptom symptom : disease1.getSymptoms()) {
			System.out.println(symptom.getId());
		}
		System.out.println(matchs(disease1, this.getSymptoms()));
		System.out.println("--------------------------------");
		for(Symptom symptom : disease2.getSymptoms()) {
			System.out.println(symptom.getId());
		}
		System.out.println(matchs(disease2, this.getSymptoms()));
		System.out.println(intersection(disease1.getSymptoms(), this.getSymptoms()).isEmpty());
		System.out.println((this.getSymptoms()).isEmpty());
		return new Integer(matchsDisease2).compareTo(new Integer(matchsDisease1));
	}


}
