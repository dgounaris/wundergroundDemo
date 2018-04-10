package connection;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

import utilities.IOHelper;

public class ConnectionManager {

	private static String API_KEY = "25b207a3bca669f7";
	
	public static JSONObject getDateHistory(int day, int month, int year) {
		
		JSONObject jsonObject = null;
		
		try {
			String urlString = "http://api.wunderground.com/api/" + API_KEY + "/history_" + year + month + day + "/q/NY/New_York.json";
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			InputStream inputStream = conn.getInputStream();
			
			jsonObject = new JSONObject(IOHelper.InputStreamToString(inputStream));
			inputStream.close();
		} catch (MalformedURLException e) {
			
		} catch (IOException e) {
			
		}
		
		return jsonObject;
		
	}
	
}
