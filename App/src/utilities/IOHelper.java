package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public static void CreateMetric(String filename, String text) throws IOException {
		BufferedWriter output = null;
		try {
			File file = new File("./src/outputs/" + filename + ".txt");
			output = new BufferedWriter(new FileWriter(file));
			output.write(text);
		} finally {
			if (output != null) {
				output.close();
			}
		}
	}
	
}
