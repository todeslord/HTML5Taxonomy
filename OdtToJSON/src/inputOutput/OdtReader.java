package inputOutput;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import main.Feature;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class OdtReader {

	public static LinkedList<Feature> getFeature() {
		try {

			LinkedList<Feature> features = new LinkedList<Feature>();

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("content.xml"));

			NodeList featureNodes = document
					.getElementsByTagName("table:table");
			for (int i = 0; i < featureNodes.getLength(); i++) {

				int j = 2;
				while (featureNodes.item(i).getChildNodes().item(j)
						.getNodeName() != "table:table-row") {
					j++;
				}

				String name = getAttribute(i, j, featureNodes);
				j++;
				if (!isAttribute(i, j, featureNodes)) {
					j++;
				}

				String shortDescription = getAttribute(i, j, featureNodes);
				j++;
				if (!isAttribute(i, j, featureNodes)) {
					j++;
				}

				String longDescription = getAttribute(i, j, featureNodes);
				j++;
				if (!isAttribute(i, j, featureNodes)) {
					j++;
				}

				String w3cLink = getAttribute(i, j, featureNodes);
				j++;
				if (!isAttribute(i, j, featureNodes)) {
					j++;
				}

				String whatwgLink = getAttribute(i, j, featureNodes);
				j++;
				if (!isAttribute(i, j, featureNodes)) {
					j++;
				}

				String status = getAttribute(i, j, featureNodes);
				j++;
				if (!isAttribute(i, j, featureNodes)) {
					j++;
				}

				String date = getAttribute(i, j, featureNodes);
				j++;
				if (!isAttribute(i, j, featureNodes)) {
					j++;
				}

				String category = getAttribute(i, j, featureNodes);
				j++;
				if (!isAttribute(i, j, featureNodes)) {
					j++;
				}

				String orientation = getAttribute(i, j, featureNodes);
				j++;
				if (!isAttribute(i, j, featureNodes)) {
					j++;
				}

				String implementationStatus = getAttribute(i, j, featureNodes);
				j++;
				if (!isAttribute(i, j, featureNodes)) {
					j++;
				}

				String sameSpec = getAttribute(i, j, featureNodes);

				features.add(new Feature(name, shortDescription,
						longDescription, w3cLink, whatwgLink, date, category,
						orientation, implementationStatus, status, sameSpec));

			}

			return features;

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static boolean isAttribute(int i, int j, NodeList featureNodes) {
		return !(null == featureNodes.item(i).getChildNodes().item(j)
				.getLastChild());
	}

	private static String getAttribute(int i, int j, NodeList featureNodes) {
		Node headNode = featureNodes.item(i).getChildNodes().item(j)
				.getLastChild();
		String text = "";
		for (int k = 0; k < headNode.getChildNodes().getLength(); k++) {
			if (headNode.getChildNodes().item(k).getFirstChild() != null) {
				if (headNode.getChildNodes().item(k).getChildNodes()
						.getLength() > 1) {
				}
				if (k > 0) {
					text += "<br>";
				}
				if (headNode.getChildNodes().item(k).getChildNodes()
						.getLength() == 1) {
					text += headNode.getChildNodes().item(k).getFirstChild()
							.getTextContent();
				} else if (headNode.getChildNodes().item(k).getChildNodes()
						.getLength() == 2) {
					// expecting <text:soft-page-break/>
					text += headNode.getChildNodes().item(k).getChildNodes()
							.item(1).getTextContent();
				} else {
					int l = headNode.getChildNodes().item(k).getChildNodes()
							.getLength();
					System.err
							.println("Error getAttribute/<text:soft-page-break/>/ length == "
									+ l);
				}

			} else {
				text += "<br>";
			}
		}
		return text;
	}
}
