package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Date: Oct 15-2020. This class writes the occurrences of symptoms in a file.
 * 
 * @author adrien
 * @version 2.0
 */
public class WriteSymptomOccurrenceToFile implements ISymptomWriter {

	private TreeMap<String, Integer> symptomsCounts;
	private String filepath;

	/**
	 * @param filepath       a full or partial path to file
	 * @param symptomsCounts a tree map object containing the occurrences associated
	 *                       to each symptom.
	 */
	public WriteSymptomOccurrenceToFile(String filepath, TreeMap<String, Integer> symptomsCounts) {
		this.filepath = filepath;
		this.symptomsCounts = symptomsCounts;
	}

	/**
	 * Writes occurrences of symptoms in a file, a symptom per line
	 */
	public void writeOccurences() {
		BufferedWriter writer = null;
		File file = new File(filepath);
		try {
			writer = new BufferedWriter(new FileWriter(file));

			for (String symptom : symptomsCounts.keySet()) {
				int count = symptomsCounts.get(symptom);
				writer.write(symptom + " : " + count);
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.printf("Impossible to write in the file %s.", file.toString());
			System.exit(-1);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				System.err.printf("The file %s cannot be closed.", file.toString());
				System.exit(-1);
			}
		}
	}

}