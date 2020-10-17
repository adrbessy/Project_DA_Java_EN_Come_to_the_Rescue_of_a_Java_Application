package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * Date: Oct 14-2020. This class process a list of symptoms to generate
 * occurrences of symptoms.
 * 
 * @author adrien
 * @version 2.0
 *
 */
public class SymptomCounter {

	private TreeMap<String, Integer> symptomsCounts = null;
	private List<String> symptomsList;

	/**
	 * 
	 * @param symptomsList a list containing symptoms
	 */
	public SymptomCounter(List<String> symptomsList) {
		symptomsCounts = new TreeMap<String, Integer>();
		this.symptomsList = symptomsList;
	}

	/**
	 * Count the occurrences of symptoms from a List, then add them in a tree map
	 * 
	 * @return a tree map object containing the occurrences associated to each
	 *         symptom
	 */
	public TreeMap<String, Integer> getSymptomOccurrences() {
		for (String symptom : symptomsList) {
			System.out.println("Processing line: " + symptom);
			if (symptomsCounts.containsKey(symptom)) {
				symptomsCounts.put(symptom, symptomsCounts.get(symptom) + 1);
			} else {
				symptomsCounts.put(symptom, 1);
			}
		}
		return symptomsCounts;
	}

}