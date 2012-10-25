package main;
import util.StringCutter;

public class Feature {

	private String name, shortDescription, longDescription, w3cLink,
			whatwgLink, date, category, orientation, implementationStatus,
			status, sameSpec;

	private boolean inserted;

	public Feature(String name, String shortDescription,
			String longDescription, String w3cLink, String whatwgLink,
			String date, String category, String orientation,
			String implementationStatus, String status, String sameSpec) {
		super();
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.w3cLink = w3cLink;
		this.whatwgLink = whatwgLink;
		this.date = date;
		this.category = category;
		this.orientation = orientation;
		this.implementationStatus = implementationStatus;
		this.status = status;
		this.sameSpec = sameSpec;
	}

	public String getAttribute(String attribute) {
		String value = "";

		if (attribute.equals("category")) {
			value = this.category;
		} else if (attribute.equals("orientation")) {
			value = this.orientation;
		} else if (attribute.equals("implementationStatus")) {
			value = this.implementationStatus;
		} else if (attribute.equals("status")) {
			value = this.status;
		} else if (attribute.equals("sameSpec")) {
			value = this.sameSpec;
		} else {
			value = null;
		}

		return StringCutter.cutComma(value);
	}

	public String getCategory() {
		return category;
	}

	public String getDate() {
		return date;
	}

	public String getImplementationStatus() {
		return implementationStatus;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public String getName() {
		return name;
	}

	public String getOrientation() {
		return orientation;
	}

	public String getSameSpec() {
		return sameSpec;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public String getStatus() {
		return status;
	}

	public String getW3cLink() {
		return w3cLink;
	}

	public String getWhatwgLink() {
		return whatwgLink;
	}

	public boolean isInserted() {
		return inserted;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setImplementationStatus(String implementationStatus) {
		this.implementationStatus = implementationStatus;
	}

	public void setInserted(boolean inserted) {
		this.inserted = inserted;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public void setSameSpec(String sameSpec) {
		this.sameSpec = sameSpec;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setW3cLink(String w3cLink) {
		this.w3cLink = w3cLink;
	}

	public void setWhatwgLink(String whatwgLink) {
		this.whatwgLink = whatwgLink;
	}

	public String getWidth() {
		int width = this.longDescription.length();
		if (width < 40) {
			width = 40;
		}
		return Integer.toString(width);
	}

}
