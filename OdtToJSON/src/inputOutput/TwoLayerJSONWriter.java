package inputOutput;

import main.CategoryDescr;
import main.Feature;
import util.StringCutter;

public class TwoLayerJSONWriter extends JSONWriter {

	private String sortingElement;

	public TwoLayerJSONWriter(String pictureName, String sortingElement) {
		String camelCaseSortingElement = sortingElement.substring(0, 1)
				.toUpperCase()
				+ sortingElement.substring(1);
		text = "function getJson" + camelCaseSortingElement
				+ "() {\nvar json =";
		this.pictureName = pictureName;
		this.sortingElement = sortingElement;
	}

	@Override
	public void writeFeature(Feature feature, String color) {
		newLine(3);
		array();
		endArray();

		newLine(3);
		text += "\"data\" : {";
		{
			newLine(4);
			// defines if the element is feature instead of menu-item
			addString("feature", "true");
			comma();

			newLine(4);
			addInt("$angularWidth", feature.getWidth());
			comma();

			newLine(4);
			addString("category", feature.getCategory());
			comma();

			newLine(4);
			addString("date", feature.getDate());
			comma();

			newLine(4);
			addString("implementationStatus", feature.getImplementationStatus());
			comma();

			newLine(4);
			addString("w3cLink", feature.getW3cLink());
			comma();

			newLine(4);
			addString("whatwgLink", feature.getWhatwgLink());
			comma();

			newLine(4);
			addString("longDescription", feature.getLongDescription());
			comma();

			newLine(4);
			addString("orientation", feature.getOrientation());
			comma();

			newLine(4);
			addString("sameSpec", feature.getSameSpec());
			comma();

			newLine(4);
			addString("shortDescription", feature.getShortDescription());
			comma();

			newLine(4);
			addString("status", feature.getStatus());
			comma();

			newLine(4);
			addString("$color", color);

		}
		newLine(3);
		text += "},";

		newLine(3);
		addString("id", this.pictureName + "/"
				+ feature.getAttribute(sortingElement) + "/"
				+ feature.getName());
		comma();
		newLine(3);
		addString("name", feature.getName());
	}
	
	public void writeFeatureProps(String sortingElementValue) {
		this.newLine(2);
		text += "\"data\" : {";
		this.newLine(3);
		this.addString("description", CategoryDescr.getLongDescr(sortingElementValue));
		this.comma();
		this.newLine(3);
		this.addString("shortDescription", CategoryDescr.getShortDescr(sortingElementValue));
		this.comma();
		this.newLine(3);
		this.addInt("$angularWidth", "0");
		this.comma();
		this.newLine(3);
		this.addString("$color", CategoryDescr.getColor(sortingElementValue));
		this.comma();
		this.newLine(3);
		this.addString("feature", "false");
		this.comma();
		this.newLine(3);
		this.addString("longName", sortingElementValue);

		this.newLine(2);
		text += "},";
		this.newLine(2);
		this.addString("id", this.pictureName + "/" + sortingElementValue);
		this.comma();
		this.newLine(2);
		this.addString("name", StringCutter.cutLongNames(sortingElementValue));

	}

}
