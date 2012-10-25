package util;

public class StringCutter {

	public static String cutComma(String name) {
		if(name.contains(",")){
			return name.substring(0, name.indexOf(","));
		}else{
			return name;
		}
	}
	
	public static String cutLongNames(String name) {
		if(name.equals("Candidate Recommendation")){
			return "Candidate R.";
		}else if(name.equals("Recommendation")){
			return "Recom.";
		}else{
			return name;
		}
	}
	
}
