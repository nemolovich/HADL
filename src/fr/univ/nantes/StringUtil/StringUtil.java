package fr.univ.nantes.StringUtil;

import java.util.List;

public class StringUtil {

	/**
	 * This function is used to join all elements from a {@link List list} of
	 * {@link String strings} in only one {@link String}. All elements of the
	 * list are separated with the given separator.
	 * 
	 * @param list
	 *            {@link List}<{@link String}> - The list of <code>String</code>
	 *            to concatenate
	 * @param sep
	 *            {@link String} - The separator to add between each elements in
	 *            the result
	 * @return {@link String} - The list concatenate in a String
	 */
	public static String join(List<String> list, String sep) {
		if (list.size() == 1) {
			return list.remove(0);
		} else {
			return list.remove(0) + sep + join(list, sep);
		}
	}
}
