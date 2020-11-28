package np.com.roshanadhikary.studentmgmt.util;

import java.util.List;

public class Stringifier {
	
	/**
	 *
	 * @param list
	 * @return a "stringified" version of the list, where each element of the list
	 * is separated by a comma
	 * e.g., ["cat", "dog", "fish"] into  "cat,dog,fish"
	 */
	public static String stringify(List<String> list) {
		
		try {
			
			StringBuilder stringBuilder = new StringBuilder();
			
			for (String string: list) {

				stringBuilder.append(string);
				stringBuilder.append(",");
			}
			
			String stringifiedList = stringBuilder.toString();
			
			// remove the last comma
			return stringifiedList.substring(0, stringifiedList.length() - 1);
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
}
