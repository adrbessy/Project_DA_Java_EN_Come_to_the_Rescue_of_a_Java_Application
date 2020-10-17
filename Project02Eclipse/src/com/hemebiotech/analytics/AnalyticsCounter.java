package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * Date: Oct 14-2020. This is a simple application for counting occurrences of
 * symptoms listed in a file.
 * 
 * @author adrien
 * @version 2.0
 *
 */
public class AnalyticsCounter {

	public static void main(String[] args) {

		ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> symptomsList = readSymptomDataFromFile.getSymptoms();

		SymptomCounter symptomCounter = new SymptomCounter(symptomsList);
		TreeMap<String, Integer> symptomsCounts = symptomCounter.getSymptomOccurrences();

		ISymptomWriter writeSymptomOccurrenceToFile = new WriteSymptomOccurrenceToFile(
				"Project02Eclipse/symptom_occurrence.out", symptomsCounts);
		writeSymptomOccurrenceToFile.writeOccurences();
	}
}