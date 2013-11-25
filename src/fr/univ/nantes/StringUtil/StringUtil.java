package fr.univ.nantes.StringUtil;

import java.util.List;

public class StringUtil {

	// public static String join(List<String> list, String sep) {
	// String joinedString = "";
	// int currentIndex = 0;
	// int maxIndex = list.size();
	// for (String s : list) {
	// joinedString += s + (currentIndex == maxIndex ? "" : ";");
	// }
	// return joinedString;
	// }

	public static String join(List<String> list, String sep) {
		if (list.size() == 1) {
			return list.remove(0);
		} else {
			return list.remove(0) + sep + join(list, ";");
		}
	}
}
