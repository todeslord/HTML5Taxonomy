package inputOutput;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import main.Feature;

public abstract class JSONWriter {

	protected String text;

	public abstract void writeFeature(Feature feature, String color);

	protected String pictureName;

	public JSONWriter() {
		super();
	}

	protected void addInt(String key, String value) {
		text += "\"" + key + "\" : " + value + "";

	}

	protected void addString(String key, String value) {
		text += "\"" + key + "\" : \"" + value + "\"";

	}

	public void array() {
		text += "\"children\" : [";

	}

	public void close() {
		text += "}";

	}

	public void comma() {
		text += ",";
	}

	public void endArray() {
		text += "],";

	}

	public void finish() {
		text += "\n   };";
		text += "\n\n   return json;\n}";

	}

	public String getText() {
		return text;
	}

	public void newLine(int tabs) {
		text += "\n";
		for (int i = 0; i < tabs; i++) {
			text += "\t";
		}
	}

	public void open() {
		text += "{\n";
	}

	public void writeToDisc(File file) {
		Writer fw = null;

		try {
			fw = new FileWriter(file);
			fw.write(this.getText());
		} catch (IOException e) {
			System.err.println("Konnte Datei nicht erstellen");
		} finally {
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	public void writeDocumentProps() {

		this.newLine(1);
		text += "\"data\" : {";
		this.newLine(2);
		this.addString("$type", "none");

		this.newLine(1);
		text += "},";
		this.newLine(1);
		this.addString("id", this.pictureName);
		this.comma();
		this.newLine(1);
		this.addString("name", this.pictureName);
	}

}