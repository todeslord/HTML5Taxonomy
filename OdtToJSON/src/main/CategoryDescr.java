package main;

import java.util.LinkedList;

import util.ColorGenerator;
import util.Tupel;

public class CategoryDescr {

	private static Tupel[] longDescription = {
			new Tupel("data",
					"All features regarding the storing, tagging and standardization of data. "),
			new Tupel("visualization",
					"All features giving an audio-visual output to the user."),
			new Tupel("access", "All features allowing user-input."),
			new Tupel(
					"communication",
					"All features covering interaction between different programming-languages via web."),
			new Tupel(
					"parallelization",
					"All features running processes in the background without interfering with the user-interface."),
		
			new Tupel("yes", "W3C and WhatWg specifications are the same."),
			new Tupel("nearly", "W3C and WhatWg specifications are nearly the same. e.g. one has extra colums."),
			new Tupel("no", "WhatWg specification is only use-oriented. W3C specification covers all aspects."),
			new Tupel("only W3C", "Only W3C is specifying this feature."),

			new Tupel("Working Draft", "The first step in specification-process is the Working Draft. A Working Group is frequently updating the spec."),
			new Tupel("Candidate Recommendation", "After the Working Draft the specification becomes Candidate Recommendation Status. In this step public review is expected."),
			new Tupel("Recommendation", "Recommendation is the final status. W3C reached consensus that this specification should be implemented."),
			
			new Tupel("XML", "This category includes the languages embedded via XML."),
			new Tupel("HTML", "This category includes all pure HTML tags."),
			new Tupel("JavaScript", "This category includes all features added to JavaScript."),
			
			new Tupel("not implemented", "When you not even find test-cases in the wild, the feature belongs to the not implemented-category"),
			new Tupel("in the wild", "In the wild are those features for which there are implementations in the web but they are not yet in heavy testing mode regarding WhatWG."),
			new Tupel("heavy testing", "If there are not covered test-cases the feature belongs to the heavy-testing-category."),
			new Tupel("implemented", "Implemented features have passed all possible test-cases and are running on all browsers.") };

	private static Tupel[] shortDescription = {
			new Tupel("data", "storage, library, tagging, collection"),
			new Tupel("visualization", "output"), new Tupel("access", "input"),
			new Tupel("communication", "within the programming-language"),
			new Tupel("parallelization", "generate background processes"),

			new Tupel("not implemented", "by any browser"),
			new Tupel("in the wild", "implementations in the web"),
			new Tupel("heavy testing", "to pass the last test-cases"),
			new Tupel("implemented", "and running on all browsers"),
			
			new Tupel("XML", "embedded languages"),
			new Tupel("HTML", "tags"),
			new Tupel("JavaScript", ""),
			
			new Tupel("yes", ""),
			new Tupel("nearly", ""),
			new Tupel("no", ""),
			new Tupel("only W3C", "is specifying"),
			
			new Tupel("Working Draft", ""),
			new Tupel("Candidate Recommendation", "Candidate Recommendation"),
			new Tupel("Recommendation", "Recommendation") };

	private static LinkedList<Tupel> color = new LinkedList<Tupel>();

	public static String getLongDescr(String sortingElementValue) {

		for (Tupel t : longDescription) {
			if (t.name.equals(sortingElementValue)) {
				return t.value;
			}
		}
		System.err.println("no LongDescription for " + sortingElementValue);
		return "no Description";
	}

	public static String getShortDescr(String sortingElementValue) {

		for (Tupel t : shortDescription) {
			if (t.name.equals(sortingElementValue)) {
				return t.value;
			}
		}
		System.err.println("no ShortDescription for " + sortingElementValue);
		return "no Description";
	}

	public static String getColor(String sortingElementValue) {

		for (Tupel t : color) {
			if (t.name.equals(sortingElementValue)) {
				return t.value;
			}
		}
		String newColor = ColorGenerator.randomColor();
		color.add(new Tupel(sortingElementValue, newColor));

		return newColor;
	}
}
