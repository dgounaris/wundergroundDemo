package utilities;

import java.io.InputStream;
import java.util.Scanner;

public class IOHelper {

	public static String InputStreamToString(InputStream is) {
		Scanner s = new Scanner(is);
		s.useDelimiter("\\A");
		String result = s.hasNext() ? s.next() : "";
		s.close();
		return result;
	}
	
}
