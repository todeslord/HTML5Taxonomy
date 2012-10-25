package main;

import inputOutput.OdtReader;
import inputOutput.TreeLayerJSONWriter;
import inputOutput.TwoLayerJSONWriter;

import java.io.File;
import java.util.LinkedList;

import util.ColorGenerator;

public class Main {

	public static void main(String[] args) {

		int featureCount = 40;
		LinkedList<String> colors = ColorGenerator.createColors(featureCount);
		LinkedList<Feature> features = OdtReader.getFeature();
		// Input Ende

		writeTwoLayerImage(features, "category", colors);
		writeTwoLayerImage(features, "orientation", colors);
		writeTwoLayerImage(features, "implementationStatus", colors);
		writeTwoLayerImage(features, "status", colors);
		writeTwoLayerImage(features, "sameSpec", colors);
		writeThreeLayerImage(features, "status", "implementationStatus", colors);
		// writeTreeLayerImage(features, "category", "status", colors);

	}

	private static void writeThreeLayerImage(LinkedList<Feature> features,
			String innerSortingElement, String outerSortingElement,
			LinkedList<String> colors) {
		TreeLayerJSONWriter out = new TreeLayerJSONWriter("HTML5",
				innerSortingElement, outerSortingElement);

		boolean firstInnerCategory = true;

		out.open();
		out.array();

		// write InnerCategories
		for (int i = 0; i < features.size(); i++) {
			if (!features.get(i).isInserted()) {
				// innerCategory eröffnen
				if (false == firstInnerCategory) {
					out.comma();
				} else {
					firstInnerCategory = false;
				}
				out.open();
				out.newLine(2);
				out.array();

				// write firstOuterCategories
				boolean firstOuterCategory = true;
				for (int j = i; j < features.size(); j++) {
					if (!features.get(i).isInserted()
							&& features.get(i)
									.getAttribute(innerSortingElement).equals(
											features.get(j).getAttribute(
													innerSortingElement))) {
						// outerCategory eröffnen
						if (false == firstOuterCategory) {
							out.comma();
						} else {
							firstOuterCategory = false;
						}
						out.open();
						out.newLine(2);
						out.array();

						{// Feature einfügen
							boolean firstFeature = true;

							for (int k = j; k < features.size(); k++) {
								if (features.get(i).getAttribute(
										innerSortingElement).equals(
										features.get(k).getAttribute(
												innerSortingElement))
										&& features.get(j).getAttribute(
												outerSortingElement).equals(
												features.get(k).getAttribute(
														outerSortingElement))) {

									if (false == firstFeature) {
										out.comma();
									} else {
										firstFeature = false;
									}
									out.open();
									out.writeFeature(features.get(k), colors
											.get(k));
									out.newLine(2);
									out.close();

									features.get(k).setInserted(true);
								}
							}
						}

						out.endArray();
						// category Eigenschaften
						out.writeOuterFeatureProps(features.get(i)
								.getAttribute(innerSortingElement), features
								.get(i).getAttribute(outerSortingElement));
						// category beenden
						out.newLine(1);
						out.close();
					}
				}

				out.endArray();
				// category Eigenschaften
				out.writeInnerFeatureProps(features.get(i).getAttribute(
						innerSortingElement));
				// category beenden
				out.newLine(1);
				out.close();
			}
		}

		out.endArray();
		// document Eigenschaften
		out.writeDocumentProps();
		out.finish();

		// Write in File
		String camelCaseInner = innerSortingElement.substring(0, 1)
				.toUpperCase()
				+ innerSortingElement.substring(1);
		String camelCaseOuter = outerSortingElement.substring(0, 1)
				.toUpperCase()
				+ outerSortingElement.substring(1);

		String sep = File.separator;
		File file = new File(".."+sep+"HTML5Visualization"+sep+"Data" + camelCaseInner
				+ camelCaseOuter + ".js");
		out.writeToDisc(file);

		reactivateFeatures(features);
	}

	private static void reactivateFeatures(LinkedList<Feature> features) {
		for (int i = 0; i < features.size(); i++) {
			if (features.get(i) != null) {
				features.get(i).setInserted(false);
			} else {
				break;
			}
		}
	}

	private static void writeTwoLayerImage(LinkedList<Feature> features,
			String sortingElement, LinkedList<String> colors) {
		TwoLayerJSONWriter out = new TwoLayerJSONWriter("HTML5", sortingElement);

		boolean firstCategory = true;

		out.open();
		out.array();

		// write Categories
		for (int i = 0; i < features.size(); i++) {
			if (!features.get(i).isInserted()) {
				// category eröffnen
				if (false == firstCategory) {
					out.comma();
				} else {
					firstCategory = false;
				}
				out.open();
				out.newLine(2);
				out.array();
				// Features einfügen
				boolean firstFeature = true;

				for (int j = i; j < features.size(); j++) {
					if (features.get(i).getAttribute(sortingElement).equals(
							features.get(j).getAttribute(sortingElement))) {

						if (false == firstFeature) {
							out.comma();
						} else {
							firstFeature = false;
						}
						out.open();
						out.writeFeature(features.get(j), colors.get(j));
						out.newLine(2);
						out.close();

						features.get(j).setInserted(true);
					}
				}

				out.endArray();
				// category Eigenschaften
				out.writeFeatureProps(features.get(i).getAttribute(
						sortingElement));
				// category beenden
				out.newLine(1);
				out.close();
			}
		}

		out.endArray();
		// document Eigenschaften
		out.writeDocumentProps();
		out.finish();

		String camelCaseSortingElement = sortingElement.substring(0, 1)
				.toUpperCase()
				+ sortingElement.substring(1);
		String sep = File.separator;
		File file = new File(".."+sep+"HTML5Visualization"+sep+"Data"
				+ camelCaseSortingElement + ".js");
		out.writeToDisc(file);

		reactivateFeatures(features);
	}

}
