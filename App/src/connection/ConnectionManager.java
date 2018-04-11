package connection;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

import utilities.IOHelper;

public class ConnectionManager {

	private static final Logger logger = Logger.getLogger(ConnectionManager.class.getName());
	
	private static final String API_KEY = "25b207a3bca669f7";
	
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
			logger.log(Level.SEVERE, "Url used is not valid", e);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Could not read input from API", e);
		}
		
		return jsonObject;
		
	}
	
}
