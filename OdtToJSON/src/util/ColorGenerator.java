package util;

import java.util.LinkedList;

public class ColorGenerator {

	public static String randomColor() {
		return "#" + randomHex() + randomHex() + randomHex();
	}

	private static String randomHex() {
		int a = (int) Math.round(Math.random() * 255);
		String b = Integer.toHexString(a);
		if (b.length() > 1) {
			b = Character.toString(Character.toUpperCase(b.charAt(0)))
					+ Character.toString(Character.toUpperCase(b.charAt(1)));
		} else {
			b = "0" + Character.toString(Character.toUpperCase(b.charAt(0)));
		}

		return b;
	}

	public static LinkedList<String> createColors(int number) {
		LinkedList<String> colors = new LinkedList<String>();
	
		for (int i = 0; i < number; i++) {
			colors.add(randomColor());
		}
		return colors;
	}
	
}
