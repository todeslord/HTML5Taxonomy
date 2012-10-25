package inputOutput;
import main.CategoryDescr;
import main.Feature;
import util.StringCutter;

public class TreeLayerJSONWriter extends JSONWriter {

	private String innerSortingElement, outerSortingElement;

	public TreeLayerJSONWriter(String pictureName, String innerSortingElement,
			String outerSortingElement) {
		String camelCaseInner = innerSortingElement.substring(0, 1)
				.toUpperCase()
				+ innerSortingElement.substring(1);
		String camelCaseOuter = outerSortingElement.substring(0, 1)
				.toUpperCase()
				+ outerSortingElement.substring(1);

		 text = "function getJson" + camelCaseInner+camelCaseOuter
		 + "() {\nvar json =";

		this.innerSortingElement = innerSortingElement;
		this.outerSortingElement = outerSortingElement;
		this.pictureName = pictureName;
	}

	@Override
	public void writeFeature(Feature feature, String color) {
		newLine(4);
		array();
		endArray();

		newLine(4);
		text += "\"data\" : {";
		{
			newLine(4);
			// defines if the element is feature instead of menu-item
			addString("feature", "true");
			comma();

			newLine(5);
			addInt("$angularWidth", feature.getWidth());
			comma();

			newLine(5);
			addString("category", feature.getCategory());
			comma();

			newLine(5);
			addString("date", feature.getDate());
			comma();

			newLine(5);
			addString("implementationStatus", feature.getImplementationStatus());
			comma();

			newLine(5);
			addString("w3cLink", feature.getW3cLink());
			comma();

			newLine(5);
			addString("whatwgLink", feature.getWhatwgLink());
			comma();

			newLine(5);
			addString("longDescription", feature.getLongDescription());
			comma();

			newLine(5);
			addString("orientation", feature.getOrientation());
			comma();

			newLine(5);
			addString("sameSpec", feature.getSameSpec());
			comma();

			newLine(5);
			addString("shortDescription", feature.getShortDescription());
			comma();

			newLine(5);
			addString("status", feature.getStatus());
			comma();

			newLine(5);
			addString("$color", color);

		}
		newLine(4);
		text += "},";

		newLine(4);
		addString("id", this.pictureName + "/"
				+ feature.getAttribute(this.innerSortingElement) + "/"
				+ feature.getAttribute(this.outerSortingElement) + "/"
				+ feature.getName());
		comma();
		newLine(4);
		addString("name", feature.getName());

	}

	public void writeInnerFeatureProps(String sortingElementValue) {
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
		addString("feature", "false");
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

	public void writeOuterFeatureProps(String innerSortingElementValue, String outerSortingElementValue) {
		this.newLine(3);
		text += "\"data\" : {";
		this.newLine(4);
		this.addString("description", CategoryDescr.getLongDescr(outerSortingElementValue));
		this.comma();
		this.newLine(4);
		this.addString("shortDescription", CategoryDescr.getShortDescr(outerSortingElementValue));
		this.comma();
		this.newLine(4);
		this.addInt("$angularWidth", "0");
		this.comma();
		this.newLine(4);
		this.addString("$color", CategoryDescr.getColor(outerSortingElementValue));
		this.comma();
		this.newLine(4);
		addString("feature", "false");
		this.comma();
		this.newLine(4);
		this.addString("longName", outerSortingElementValue);

		this.newLine(3);
		text += "},";
		this.newLine(3);
		this.addString("id", this.pictureName + "/" + innerSortingElementValue + "/" + outerSortingElementValue);
		this.comma();
		this.newLine(3);
		this.addString("name", StringCutter.cutLongNames(outerSortingElementValue));
		
	}

}
